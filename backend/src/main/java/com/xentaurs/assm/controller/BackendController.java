package com.xentaurs.assm.controller;

import com.xentaurs.assm.domain.User;
import com.xentaurs.assm.domain.AssmProject;
import com.xentaurs.assm.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/hello")
    public @ResponseBody String sayHello() {
        LOG.info("GET called on /hello resource");
        return HELLO_TEXT;
    }

    /*@RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody long addNewUser (@RequestParam String firstName, @RequestParam String lastName) {
        User user = new User(firstName, lastName);
        userRepository.save(user);

        LOG.info(user.toString() + " successfully saved into DB");

        return user.getId();
    }

    /*@GetMapping(path="/user/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") long id) {
        LOG.info("Reading user with id " + id + " from database.");
        return userRepository.findById(id).get();
    }*/

    //@CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin(origins = "*")
    @GetMapping(path="/getassm")
    public @ResponseBody List<AssmProject> getAssmProject() {
        /*return new AssmProject("GMF");*/
        List<AssmProject> assmList = new ArrayList<AssmProject>();
        assmList.add(new AssmProject("GMF"));
        assmList.add(new AssmProject("Chico's"));
        assmList.add(new AssmProject("Availity"));
        assmList.add(new AssmProject("Cisco"));
        assmList.add(new AssmProject("Honor Health"));
        assmList.add(new AssmProject("Loftware Inc"));
        assmList.add(new AssmProject("Mercantil Bank"));
        assmList.add(new AssmProject("PSCU"));
        return assmList;
    }

}
