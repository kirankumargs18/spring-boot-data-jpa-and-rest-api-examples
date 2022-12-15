package com.globallogic.service;

import java.util.List;

import com.globallogic.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

}
