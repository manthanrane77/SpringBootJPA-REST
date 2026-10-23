package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	
	@Query(value = "select count(id) from employee",nativeQuery = true)
	public int getEmployeeCount();
	
	public List<Employee> findByfirstName(String firstname);

}
