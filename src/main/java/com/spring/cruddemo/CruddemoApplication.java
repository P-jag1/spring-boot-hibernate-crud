package com.spring.cruddemo;

import com.spring.cruddemo.dao.StudentDAO;
import com.spring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//bean and method for command line application
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Delete row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 3;
		// delete student of id 3
		studentDAO.deleteStudent(id);

	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id
		int studentId = 1;
		Student myStudent = studentDAO.findById(studentId);
		// change first name to "Scooby
		myStudent.setFirstName("John");
		// update the student
		studentDAO.update(myStudent);
		//display the student
		System.out.println(myStudent);
	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {

		//get a list
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		//display list
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get list
		List<Student> theStudents = studentDAO.findAll();
		// display
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student
		System.out.println("Creating new student object...");
		Student tempStudent1 = new Student("Duffy", "Duck", "Duffy@doe.com");

		// save student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);

		//display
		int theId = tempStudent1.getId();
		System.out.println("id: " + theId);

		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println(myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("John", "Doe", "John@doe.com");
		Student tempStudent2 = new Student("Mary", "Doe", "Mary@doe.com");
		Student tempStudent3 = new Student("Bonita", "Doe", "bonita@doe.com");


		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}


	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@doe.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}

}
