package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDAO;
import com.app.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO=employeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeDAO.findById(id).orElse(null);
	}

	@Override
	public Employee save(Employee employee) {
		return employeeDAO.save(employee);
		
	}

	@Override
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
	}

	@Override
	public int getEmployeeCount() {
		return employeeDAO.getEmployeeCount();
	}

	@Override
	public List<Employee> findByFirstName(String firstname) {
		return employeeDAO.findByfirstName(firstname);
	}


}
