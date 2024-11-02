package com.springbootexample.cruddemo.service;

import com.springbootexample.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findall();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);
}
