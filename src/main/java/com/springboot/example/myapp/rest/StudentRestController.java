package com.springboot.example.myapp.rest;

import com.springboot.example.myapp.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        //check the studentId against the list size
        if(studentId < 0 || studentId > students.size()){
            throw new StudentNotFoundException("Student id "+ studentId +" not found");
        }

        //just index into the list besed on index of the list...
        return students.get(studentId);
    }
}
