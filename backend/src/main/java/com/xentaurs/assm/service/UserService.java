package com.xentaurs.assm.service;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.xentaurs.assm.web.error.UserAlreadyExistException;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Arrays;
import com.xentaurs.assm.domain.User;
import com.xentaurs.assm.domain.Role;
import com.xentaurs.assm.repository.UserRepository;
import com.xentaurs.assm.repository.RoleRepository;
import com.xentaurs.assm.model.NewUser;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // API
    @Override
    public User registerNewUserAccount(final NewUser newUser) {
        if (emailExists(newUser.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + newUser.getEmail());
        } else if (usernameExists(newUser.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that username adress: " + newUser.getUsername());
        }

        final User user = new User(
                newUser.getUsername(),
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword())
        );
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));

        return userRepository.save(user);
    }

    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }

    private boolean usernameExists(final String username) {
        return userRepository.findByUsername(username) != null;
    }


}
