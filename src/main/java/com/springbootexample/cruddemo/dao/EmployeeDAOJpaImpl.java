package com.springbootexample.cruddemo.dao;

import com.springbootexample.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    //define fields for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        //execute query and get results
        List<Employee> employees = query.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {

        // get employee
        Employee employee = entityManager.find(Employee.class, id);

        //return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {

        //save employee
        Employee savedEmployee = entityManager.merge(employee);

        //return dbemployee
        return savedEmployee;
    }

    @Override
    public void delete(int id) {

        //find employee by id
        Employee employee = entityManager.find(Employee.class,id);

        //remove employee
        entityManager.remove(employee);
    }
}
