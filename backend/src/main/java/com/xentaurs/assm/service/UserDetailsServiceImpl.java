package com.xentaurs.assm.service;

import com.xentaurs.assm.domain.User;
import com.xentaurs.assm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /*User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));*/

        /*try {
            User user = userRepository.findByUsername(username);
        } catch (UsernameNotFoundException e) {

        }*/

        User user = userRepository.findByUsername(username);

        return UserPrinciple.build(user);
    }
}
