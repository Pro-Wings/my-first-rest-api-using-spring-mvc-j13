package com.prowings.service;

import java.util.List;

import com.prowings.entity.Employee;

public interface EmployeeCrudService {
	
	public Employee getEmployeeById(int id);

	public List<Employee> getAllEmployees();
	
	public boolean saveEmployee(Employee employee);
	
	public Employee updateEmployee(int id);

	public Employee deleteEmployee(int id);

}
