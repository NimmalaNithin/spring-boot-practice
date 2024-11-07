package com.springbootexample.cruddemo.dao;

import com.springbootexample.cruddemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
