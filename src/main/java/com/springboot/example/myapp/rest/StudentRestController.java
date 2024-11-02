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

    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //add another exception handler... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        //instead of exc.getMessage() you can give any custom message
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
