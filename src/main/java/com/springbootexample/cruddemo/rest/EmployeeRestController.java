package com.springbootexample.cruddemo.rest;

import com.springbootexample.cruddemo.entity.Employee;
import com.springbootexample.cruddemo.exception.custom.EmployeeNotFoundException;
import com.springbootexample.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose '/employees' and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findall();
    }

    //add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        if(employee == null) {
            throw new EmployeeNotFoundException("Employee not found - " + employeeId );
        }

        return employee;
    }

    //add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        //also just in case an id is passed in JSON... set id to 0
        //this is to force to save a new item.. instead of update
        employee.setId(0);

        Employee savedEmployee = employeeService.save(employee);

        return savedEmployee;
    }

    //add mapping for PUT /employees - update an existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        Employee emp = employeeService.findById(employee.getId());
        if(emp == null) {
            throw new EmployeeNotFoundException("Employee not found - " + employee.getId() );
        }

        Employee updatedEmployee = employeeService.save(employee);

        return updatedEmployee;
    }

    //add mapping for DELETE /employees/{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        //throw exception if null
        if(employee == null) {
            throw new EmployeeNotFoundException("Employee id not found - " + employeeId );
        }

        employeeService.delete(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
