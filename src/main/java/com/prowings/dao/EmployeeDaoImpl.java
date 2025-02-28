package com.prowings.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prowings.entity.Employee;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Employee getEmployeeById(int id) {
		log.info("EmployeeDaoImpl.getEmployeeById() invoked!!");
		Employee fetchedEmployee = null;
		try {
			Session session = sessionFactory.openSession();
			fetchedEmployee = session.get(Employee.class, id);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occured while fetching employee!!");
		}
		if (fetchedEmployee != null) {
			log.info("Employee fetched successfully!!");
		} else {
			log.info("Employee not fetched successfully!!");
		}
		return fetchedEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		log.info("EmployeeDaoImpl.getAllEmployees() invoked!!");
		return null;
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		boolean result = false;
		log.info("EmployeeDaoImpl.saveEmployee() invoked!!");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(employee);
			tx.commit();
			session.close();
			result = true;
			log.info("Employee saved successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occured while saving employee!!");
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
