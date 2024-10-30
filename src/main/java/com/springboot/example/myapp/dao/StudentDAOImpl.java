package com.springboot.example.myapp.dao;

import com.springboot.example.myapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //define field for manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student",Student.class);

        //return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findAllSortedByLastName() {
        //create query (you can use asc or desc either in capital letters or small letters same as in SQL query)
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName",Student.class);

        //return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);

        //set query parameter
        query.setParameter("theData", lastName);

        //return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public Integer updateAll(String lastName) {
        //create query to update
        // Two ways of doing it

        //int numRowsUpdated = entityManager.createQuery("UPDATE Student SET lastName='Tester'").executeUpdate();

        //OR

        Query query = entityManager.createQuery("UPDATE Student SET lastName=:theData");

        //set parameter
        query.setParameter("theData", lastName);

        //update and return the number of rows updated
        return query.executeUpdate();

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student student = entityManager.find(Student.class, id);

        //delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public Integer deleteAll() {
        Integer numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }

}
