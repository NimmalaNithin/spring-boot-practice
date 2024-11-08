package com.springbootexample.cruddemo.service;

import com.springbootexample.cruddemo.dao.RoleRepository;
import com.springbootexample.cruddemo.dao.UserRepository;
import com.springbootexample.cruddemo.entity.User;
import com.springbootexample.cruddemo.entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);

        if(user==null){
            throw new UsernameNotFoundException("Invalid Username or Password");
        }

        return new UserPrincipal(user);
    }

    @Override
    public User register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRoles(Collections.singleton(roleRepository.findByName("ROLE_EMPLOYEE")));
        return userRepository.save(user);
    }
}
