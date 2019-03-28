package com.xentaurs.assm.controller;

import com.xentaurs.assm.model.NewUser;
import com.xentaurs.assm.domain.User;
import com.xentaurs.assm.domain.Role;
import com.xentaurs.assm.service.IUserService;
import com.xentaurs.assm.repository.UserRepository;
import com.xentaurs.assm.repository.RoleRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
/*import com.xentaurs.assm.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
import java.util.List;
import com.google.common.collect.Lists;

@RestController()
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //@CrossOrigin(origins = "http://localhost:8080")

    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public @ResponseBody User addNewUser(@RequestBody NewUser newUser) throws Exception {
        /*User user = new User(newUser.getUsername(),
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getEmail(),
                newUser.getPassword()
            );
        userRepository.save(user);

        return user;*/
        final User registered = userService.registerNewUserAccount(newUser);

        return registered;
    }

    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/r", method = RequestMethod.GET)
    public NewUser addNewUser() {
        return new NewUser("1", "2", "3", "4", "5");
    }

    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/getroles", method = RequestMethod.GET)
    public List<Role> getRoles() {
        return Lists.newArrayList(roleRepository.findAll());
    }

    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/getusers", method = RequestMethod.GET)
    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

}
