package com.springbootexample.cruddemo.service;

import com.springbootexample.cruddemo.dao.UserRepository;
import com.springbootexample.cruddemo.entity.User;
import com.springbootexample.cruddemo.entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);

        if(user==null){
            throw new UsernameNotFoundException("Invalid Username or Password");
        }

        return new UserPrincipal(user);
    }
}
