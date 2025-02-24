package com.prowings.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Employee;
import com.prowings.entity.Error1;
import com.prowings.entity.Error2;
import com.prowings.entity.ErrorResponse;
import com.prowings.service.EmployeeCrudService;

@RestController
@RequestMapping("/prowings")
public class EmployeeCrudController {
	
	@Autowired
	private EmployeeCrudService employeeService;
	
	@PostMapping("/employees")
	public ResponseEntity<String> save(@RequestBody Employee employee)
	{
		System.out.println("EmployeeCrudController.save() invoked!!");
		System.out.println("Received Employee : "+employee);
		
		if(employeeService.saveEmployee(employee))
		{
			return new ResponseEntity<String>("Employee saved successfully!!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Failed to save employee!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/employees/{id}",produces = "application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id, @RequestHeader HttpHeaders requestHeaders) {
		System.out.println("EmployeeCrudController.getEmployeeById() invoked!!");
		System.out.println("Received Request Headers : "+requestHeaders);
		System.out.println("Received Employee Id : "+id);
		
		String company = requestHeaders.getFirst("company");
		System.out.println("Company : "+company);
		if (company.equals("prowings")) {
			System.out.println("--------Company is prowings!!----------");
		}
		Employee fetchedeEmp = employeeService.getEmployeeById(id);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("message", "hiii");
		responseHeaders.add("name", fetchedeEmp.getName());
		
		ResponseEntity<Employee> rs = new ResponseEntity<Employee>(fetchedeEmp, responseHeaders, HttpStatus.CREATED);
		
		return rs;
	}


//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<Error2> handleRuntimeEx(RuntimeException ex) {
//    	
//    	Error2 e1 = new Error2("Some error at Server!!", ex.getMessage(), 2394);    	
//    	return new ResponseEntity<Error2>(e1, HttpStatus.BAD_REQUEST);
//    }
	
}
