package com.globallogic.service;

import java.util.List;

import com.globallogic.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee createEmployee(Employee employee);

	Employee getEmployeeById(long id);

	Employee updateEmployee(long id, Employee employee);
	
	void deleteEmployee(long id);

}
