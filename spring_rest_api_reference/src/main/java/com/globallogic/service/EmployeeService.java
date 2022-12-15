package com.globallogic.service;

import java.util.List;

import com.globallogic.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee addEmployee(Employee employee);

	Employee getEmployeeById(long id);

	Employee updateEmployeeById(long id, Employee employee);

	void deleteEmployeeById(long id);

}
