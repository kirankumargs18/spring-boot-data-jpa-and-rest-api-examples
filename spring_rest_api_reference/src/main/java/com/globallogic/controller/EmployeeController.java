package com.globallogic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.entity.Employee;
import com.globallogic.service.EmployeeService;
import com.globallogic.utils.AppConstants;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();
	}

	/*
	 * add @Valid only if you validation annotations in entity or dto class
	 */
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {

		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);

	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = AppConstants.ID) long id) {

		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	/*
	 * add @Valid only if you validation annotations in entity or dto class
	 */
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = AppConstants.ID) long id,
			@Valid @RequestBody Employee employee) {

		return new ResponseEntity<>(employeeService.updateEmployeeById(id, employee), HttpStatus.OK);

	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable(value = AppConstants.ID) long id) {

		return new ResponseEntity<>(AppConstants.DELETE_MESSAGE, HttpStatus.OK);

	}
}
