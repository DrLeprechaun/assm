package com.xentaurs.assm.controller;

import com.xentaurs.assm.domain.User;
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

}
