package com.xentaurs.assm.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.google.common.collect.Lists;

import com.xentaurs.assm.domain.Role;
import com.xentaurs.assm.domain.User;
import com.xentaurs.assm.model.ManagedAccount;
import com.xentaurs.assm.repository.RoleRepository;
import com.xentaurs.assm.repository.UserRepository;
import com.xentaurs.assm.web.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import com.xentaurs.assm.model.AccountInfo;
import org.springframework.security.crypto.password.PasswordEncoder;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/getaccount")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public @ResponseBody AccountInfo getMyAccount(Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        return new AccountInfo(
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    @GetMapping("/getaccounts")
    @PreAuthorize("hasRole('ADMIN')")
    public @ResponseBody List<ManagedAccount> getAccounts() {

        ArrayList<User> users = Lists.newArrayList(userRepository.findAll());
        ArrayList<ManagedAccount> accounts = new ArrayList<ManagedAccount>();

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");

        for (User user : users) {
            accounts.add(new ManagedAccount(
                    user.getId(),
                    user.getUsername(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getRoles().contains(adminRole)
            ));
        }

        return accounts;
    }

    @PostMapping ("/updateAccount")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public @ResponseBody AccountInfo updateAccount(Authentication authentication, @RequestParam String firstName, @RequestParam String lastName) {
        User user = userRepository.findByUsername(authentication.getName());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
        return new AccountInfo(
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );
    };

    @PostMapping ("/updatePassword")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> updatePassword(Authentication authentication, @RequestParam String password, @RequestParam String newPassword, @RequestParam String confirmPassword) {

        User user = userRepository.findByUsername(authentication.getName());

        if (passwordEncoder.matches(password, user.getPassword())) {
            if (new String(newPassword).equals(confirmPassword)) {
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
                return new ResponseEntity<>(new ResponseMessage("The password has been changed"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseMessage("Passwords are not match"),
                        HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(new ResponseMessage("Password is incorrect"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/makeAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> makeAdmin(@RequestParam long id) {
        try {
            User user = userRepository.findById(id);
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            Role userRole = roleRepository.findByName("ROLE_USER");
            Collection<Role> roles = new ArrayList<Role>();
            roles.add(userRole);
            roles.add(adminRole);
            user.setRoles(roles);
            userRepository.save(user);
            return new ResponseEntity<>(new ResponseMessage("User is admin"), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(new ResponseMessage("Can't make admin"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/makeRegular")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> makeRegular(@RequestParam long id) {
        try {
            User user = userRepository.findById(id);
            Role userRole = roleRepository.findByName("ROLE_USER");
            Collection<Role> roles = new ArrayList<Role>();
            roles.add(userRole);
            user.setRoles(roles);
            userRepository.save(user);
            return new ResponseEntity<>(new ResponseMessage("User is regular user"), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(new ResponseMessage("Can't make regular"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deleteUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletUser(@RequestParam long id) {
        try {
            User user = userRepository.findById(id);
            userRepository.delete(user);
            return new ResponseEntity<>(new ResponseMessage("User is deleted"), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(new ResponseMessage("Can't delte user"),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
