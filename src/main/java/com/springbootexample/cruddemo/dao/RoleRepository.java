package com.springbootexample.cruddemo.dao;

import com.springbootexample.cruddemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
