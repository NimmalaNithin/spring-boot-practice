package com.springboot.example.myapp;

import com.springboot.example.myapp.dao.StudentDAO;
import com.springboot.example.myapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class 	MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//CREATE single record
			//createStudent(studentDAO);

			//CREATE multiple records
			createMultipleStudentDAO(studentDAO);

			//READ a single record
			//readStudent(studentDAO);

			//READ multiple records
			//getAllStudents(studentDAO);

			//READ all students by sorting based on LastName
			//getStudentsSorted(studentDAO);

			//READ students by lastName
			//getStudentByLastName(studentDAO);

			//UPDATE a single record
			//updateStudent(studentDAO);

			//UPDATE all records
			//updateAll(studentDAO);

			//DELETE a single record
			//deleteStudent(studentDAO);

			//DELETE all records
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted rows count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 3;
		System.out.println("Deleteing student with id: "+id);
		studentDAO.delete(id);
	}

	private void updateAll(StudentDAO studentDAO) {
		//update last name in all records to "Tester"

		//without passing parameter
		//int numRowsUpdated = studentDAO.updateAll();

		//with passing parameter
		int numRowsUpdated = studentDAO.updateAll("dev");

		//display number of rows updated
		System.out.println("number of rows updated: "+numRowsUpdated);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on id: primary key
		int id = 2;
		System.out.println("Getting student with id: "+id);
		Student student = studentDAO.findById(id);

		//change first name to "Scooby"
		System.out.println("Updating student...");
		student.setFirstName("John");

		//update the student
		studentDAO.update(student);

		//display the updated student
		System.out.println("Updated student: "+student);

	}

	private void getStudentByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students = studentDAO.findByLastName("Balm");

		//display list of students
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void getStudentsSorted(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students = studentDAO.findAllSortedByLastName();

		//display list of students
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void getAllStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students = studentDAO.findAll();

		//display list of students
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Createing new studnet object...");
		Student tempStudent = new Student("Nithin","Nimmala","nithin@gmail.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the student
		int id = tempStudent.getId();
		System.out.println("Saved studend. Generated id: "+id);

		//retrieve the student based on id: primary key
		System.out.println("Retrieving the student with id: "+id);
		Student student = studentDAO.findById(id);

		//display student
		System.out.println("Found student: "+student);
	}

	private void createMultipleStudentDAO(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 new students...");
		Student tempStudent1 = new Student("John","Reddy","john@gmail.com");
		Student tempStudent2 = new Student("Mary","Public","mary@gmail.com");
		Student tempStudent3 = new Student("Apple","Balm","apple@gmail.com");

		//save the student objects
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Nithin","Nimmala","nithin@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display the id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}

}
