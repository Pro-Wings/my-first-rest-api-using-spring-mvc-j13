package com.prowings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Student;

//@Controller
//@ResponseBody
@RestController
public class StudentController {
	
	@GetMapping("/students")
	public Student getStudent() {
		System.out.println("StudentController.getStudent() invoked.!!");
		Student student = new Student();
		student.setId(101);
		student.setName("Raj");
		student.setEmail("raj.abc@gmail.com");
		student.setPhone("1234567890");

		return student;
	}
	
	@PostMapping("/students")
	public boolean saveStudent(@RequestBody Student student) {
		System.out.println("StudentController.saveStudent() invoked.!!");
		System.out.println(">>> Received Student from request : "+student);
		return true;
	}
	
	@GetMapping("/greet")
	public String greet() {
		System.out.println("StudentController.greet() invoked.!!");
		return "Hello";
	}
}
