package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> save(@RequestBody Employee employee){
		Employee e=employeeService.save(employee);
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	public String findByid(@PathVariable int id) {
		Employee e=employeeService.findById(id);
		if(e==null) {
			return "Employee not found";
		}else
		return "Employee="+ e;
	};
	
	@GetMapping("/employees")
	public List<Employee> getEmployee(){
		return employeeService.findAll();
	}
	
	@GetMapping("employee/firstName")
	public List<Employee> findbyFirstName(@RequestParam String name ) {
		return employeeService.findByFirstName(name);
	}
	
	@GetMapping("/employee/count")
	public int getEmployeeCount(){
		return employeeService.getEmployeeCount();
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteById(@PathVariable int id) {
		employeeService.deleteById(id);
		
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee>update(@RequestBody Employee employee){
		System.out.println("in update");
		Employee e= employeeService.save(employee);
		return new ResponseEntity<Employee>(e,HttpStatus.CREATED);
		
	}
	
	

}
