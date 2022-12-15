package com.globallogic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.entity.Employee;
import com.globallogic.repository.EmployeeRepository;
import com.globallogic.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/*
	 * @Description : It adds employee
	 * 
	 * @Params : It takes Employee as parameter
	 * 
	 * @Returns : It returns Employee
	 * 
	 * @Throws : Exception
	 * 
	 * @createdBy : Kiran
	 * 
	 * @CreatedDate : 31/10/2022
	 */
	@Override
	public Employee addEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {

		return employeeRepository.findById(id).get();
	}

}
