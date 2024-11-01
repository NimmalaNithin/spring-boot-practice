package com.springboot.example.myapp.rest;

import com.springboot.example.myapp.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //define end point for "/students" - return a lst of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "RossiMary"));
        students.add(new Student("Mary", "Smith"));

        return students;
    }
}
