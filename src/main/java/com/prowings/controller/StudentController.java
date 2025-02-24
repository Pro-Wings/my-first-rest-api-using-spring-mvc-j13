package com.prowings.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Address;
import com.prowings.entity.Student;
import com.prowings.exception.InvalidNameException;

//@Controller
//@ResponseBody
@RestController
public class StudentController {
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		System.out.println("StudentController.getAllStudents() invoked.!!");
		
		Address address = new Address();
		address.setCity("Pune");
		address.setState("MH");
		address.setCountry("India");
		address.setPin("411057");

		Address address1 = new Address();
		address1.setCity("Mumbai");
		address1.setState("MH");
		address1.setCountry("India");
		address1.setPin("411000");
		
		
		Student student = new Student();
		student.setId(101);
		student.setName("Raj");
		student.setEmail("raj.abc@gmail.com");
		student.setPhone("1234567890");
		student.setAddress(address);

		Student student1 = new Student();
		student1.setId(102);
		student1.setName("Ram");
		student1.setEmail("ram123@gmail.com");
		student1.setPhone("987654321");
		student1.setAddress(address1);

		return new ArrayList(Arrays.asList(student, student1));
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable Integer id) 
	{
		System.out.println("StudentController.getStudentById() invoked.!!");
		System.out.println(">>> Received id from request : "+id);
		if(10==10)
			throw new RuntimeException("Invalid Student Id!!");
		return null;
	}

	@GetMapping("/students/{id}/subjects/{subjectId}")
	public Student getStudentById(@PathVariable Integer id, @PathVariable String subjectId) 
	{
		System.out.println("StudentController.getStudentById() invoked.!!");
		System.out.println(">>> Received id from request : "+id);
		System.out.println(">>> Received subject id from request : "+subjectId);
		return null;
	}

	@GetMapping("/products/{category}/{id}")
	public String getProduct(@PathVariable Map<String, String> pathVars) {
	    String category = pathVars.get("category");
	    String id = pathVars.get("id");
	    return "Category: " + category + ", Product ID: " + id;
	}
	
	
	@GetMapping("/person")
	public String helloPerson(@RequestParam String name, @RequestParam int age, @RequestParam String gender) {
	    return "Hello, " + name + "you are now "+age+" years old "+ "Gender = "+gender;
	}	
	
	@GetMapping("/order/{orderId}/item/{itemId}")
	public String getOrderDetails(@PathVariable int orderId, 
	                              @PathVariable int itemId, 
	                              @RequestParam(required = false, defaultValue = "USD") String currency) {
	    return "Order ID: " + orderId + ", Item ID: " + itemId + ", Currency: " + currency;
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
