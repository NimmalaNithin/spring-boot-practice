package com.springboot.example.myapp.dao;

import com.springboot.example.myapp.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllSortedByLastName();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    Integer updateAll(String lastName);

    void delete(Integer id);

    Integer deleteAll();

}
