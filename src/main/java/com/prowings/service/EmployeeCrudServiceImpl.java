package com.prowings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.EmployeeDao;
import com.prowings.entity.Employee;
import com.prowings.exception.InvalidNameException;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EmployeeCrudServiceImpl implements EmployeeCrudService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee getEmployeeById(int id) {
		log.info("EmployeeCrudServiceImpl.getEmployeeById() invoked!!");
//		if(10==10)
//			throw new RuntimeException("Exception occured while fetching employee!!");
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		log.info("EmployeeCrudServiceImpl.getAllEmployees() invoked!!");
		return employeeDao.getAllEmployees();
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		log.info("EmployeeCrudServiceImpl.saveEmployee() invoked!!");
		boolean result = false;
		//validate employee
		if(null!= employee)
		{
			String name = employee.getName();
			if (null != name && name.length() > 3) {
				log.info("Employee name is valid!!");
				result = employeeDao.saveEmployee(employee);
			} else {
				throw new InvalidNameException("Employee name is invalid!!");
			}
		}
		return result;
		
	}

	@Override
	public Employee updateEmployee(int id) {
		log.info("EmployeeCrudServiceImpl.updateEmployee() invoked!!");
		return employeeDao.updateEmployee(id);
	}

	@Override
	public Employee deleteEmployee(int id) {
		log.info("EmployeeCrudServiceImpl.deleteEmployee() invoked!!");
		return employeeDao.deleteEmployee(id);
	}

}
