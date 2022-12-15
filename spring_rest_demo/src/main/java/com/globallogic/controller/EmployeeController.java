package com.globallogic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.entity.Employee;
import com.globallogic.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public Employee addNewEmployee(@RequestBody Employee employee) {
		
		return employeeService.addEmployee(employee);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		
		return employeeService.getAllEmployees();
	}

	@GetMapping("employees/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") long id) {

		return employeeService.getEmployeeById(id);

	}

}
