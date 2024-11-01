package com.springboot.example.myapp.rest;

import com.springboot.example.myapp.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

   //define @PostConstruct to load the student data... only once when the bean is consgtructed.
    @PostConstruct
    public void loadData(){
        students = new ArrayList<Student>();
        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "RossiMary"));
        students.add(new Student("Mary", "Smith"));
    }

    //define end point for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    //define end point "/student/{studentid}" - return a particular student with id studentid
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list besed on index of the list...
        return students.get(studentId);
    }
}
