package com.prowings.dao;

import java.util.List;

import com.prowings.entity.Employee;

public interface EmployeeDao {

	public Employee getEmployeeById(int id);

	public List<Employee> getAllEmployees();

	public boolean saveEmployee(Employee employee);

	public Employee updateEmployee(int id);

	public Employee deleteEmployee(int id);

}
