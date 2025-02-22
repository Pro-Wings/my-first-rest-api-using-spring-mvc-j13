package com.prowings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.EmployeeDao;
import com.prowings.entity.Employee;

@Service
public class EmployeeCrudServiceImpl implements EmployeeCrudService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee getEmployeeById(int id) {
		System.out.println("EmployeeCrudServiceImpl.getEmployeeById() invoked!!");
		if(10==10)
			throw new RuntimeException("Exception occured while fetching employee!!");
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		System.out.println("EmployeeCrudServiceImpl.getAllEmployees() invoked!!");
		return employeeDao.getAllEmployees();
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		System.out.println("EmployeeCrudServiceImpl.saveEmployee() invoked!!");
		return employeeDao.saveEmployee(employee);
	}

	@Override
	public Employee updateEmployee(int id) {
		System.out.println("EmployeeCrudServiceImpl.updateEmployee() invoked!!");
		return employeeDao.updateEmployee(id);
	}

	@Override
	public Employee deleteEmployee(int id) {
		System.out.println("EmployeeCrudServiceImpl.deleteEmployee() invoked!!");
		return employeeDao.deleteEmployee(id);
	}

}
