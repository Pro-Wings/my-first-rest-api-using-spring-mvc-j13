package com.prowings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Employee;
import com.prowings.service.EmployeeCrudService;

@RestController
@RequestMapping("/prowings")
public class EmployeeCrudController {
	
	@Autowired
	private EmployeeCrudService employeeService;
	
	@PostMapping("/employees")
	public void save(@RequestBody Employee employee)
	{
		System.out.println("EmployeeCrudController.save() invoked!!");
		System.out.println("Received Employee : "+employee);
		
		if(employeeService.saveEmployee(employee))
		{
			System.out.println("Employee saved successfully!!");
		} else {
			System.out.println("Employee not saved successfully!!");
		}
		
	}
	
	@GetMapping(value="/employees/{id}",produces = "application/json")
	public Employee getEmployeeById(@PathVariable int id) {
		System.out.println("EmployeeCrudController.getEmployeeById() invoked!!");
		System.out.println("Received Employee Id : "+id);
		return employeeService.getEmployeeById(id);
	}

}
