package com.globallogic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.entity.Employee;
import com.globallogic.exception.EmployeeNotFoundException;
import com.globallogic.repository.EmployeeRepository;
import com.globallogic.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {

		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id : " + id + " not found"));
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {

		Employee newEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id : " + id + " not found"));
		newEmployee.setId(employee.getId());
		newEmployee.setName(employee.getName());
		newEmployee.setProjects(employee.getProjects());

		return employeeRepository.save(newEmployee);
	}

	@Override
	public void deleteEmployee(long id) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id : " + id + " not found"));
		employeeRepository.delete(employee);

	}

}
