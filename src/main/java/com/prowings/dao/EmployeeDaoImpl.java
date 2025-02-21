package com.prowings.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prowings.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Employee getEmployeeById(int id) {
		System.out.println("EmployeeDaoImpl.getEmployeeById() invoked!!");
		Employee fetchedEmployee = null;
		try {
			Session session = sessionFactory.openSession();
			fetchedEmployee = session.get(Employee.class, id);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while fetching employee!!");
		}
		if (fetchedEmployee != null) {
			System.out.println("Employee fetched successfully!!");
		} else {
			System.out.println("Employee not fetched successfully!!");
		}
		return fetchedEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		System.out.println("EmployeeDaoImpl.getAllEmployees() invoked!!");
		return null;
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		boolean result = false;
		System.out.println("EmployeeDaoImpl.saveEmployee() invoked!!");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(employee);
			tx.commit();
			session.close();
			result = true;
			System.out.println("Employee saved successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while saving employee!!");
		}
		return result;
	}

	@Override
	public Employee updateEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
