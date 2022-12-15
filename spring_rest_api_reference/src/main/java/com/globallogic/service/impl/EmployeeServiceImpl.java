package com.globallogic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.entity.Employee;
import com.globallogic.exception.ResourceNotFoundException;
import com.globallogic.repository.EmployeeRepository;
import com.globallogic.service.EmployeeService;
import com.globallogic.utils.AppConstants;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/*
	 * @Description : To get all Employees
	 * 
	 * @Returns : It returns List of Employees
	 * 
	 * @createdBy : Kiran Kumar G S
	 * 
	 * @CreatedDate : 31/10/2022
	 */
	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	/*
	 * @Description : To add an Employee
	 * 
	 * @Params : It takes an Employee as parameter
	 * 
	 * @Returns : It returns an Employee
	 * 
	 * @createdBy : Kiran Kumar G S
	 * 
	 * @CreatedDate : 31/10/2022
	 */
	@Override
	public Employee addEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	/*
	 * @Description : To get an Employee by id
	 * 
	 * @Params : It takes an Employee ID as parameter
	 * 
	 * @Returns : It returns an Employee
	 * 
	 * @createdBy : Kiran Kumar G S
	 * 
	 * @CreatedDate : 31/10/2022
	 */
	@Override
	public Employee getEmployeeById(long id) {

		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.RESOURCE_NOT_FOUND_MESSAGE + id));
	}

	/*
	 * @Description : To update an Employee by id
	 * 
	 * @Params : It takes an Employee ID and Employee as parameters
	 * 
	 * @Returns : It returns an Employee
	 * 
	 * @createdBy : Kiran Kumar G S
	 * 
	 * @CreatedDate : 31/10/2022
	 */
	@Override
	public Employee updateEmployeeById(long id, Employee employee) {

		Employee newEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.RESOURCE_NOT_FOUND_MESSAGE + id));

		newEmployee.setFirstName(employee.getFirstName());
		newEmployee.setLastName(employee.getLastName());
		newEmployee.setSalary(employee.getSalary());
		newEmployee.setAge(employee.getAge());

		return employeeRepository.save(newEmployee);
	}

	/*
	 * @Description : To get an Employee by id
	 * 
	 * @Params : It takes an Employee ID as parameter
	 * 
	 * @createdBy : Kiran Kumar G S
	 * 
	 * @CreatedDate : 31/10/2022
	 */
	@Override
	public void deleteEmployeeById(long id) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.RESOURCE_NOT_FOUND_MESSAGE + id));

		employeeRepository.delete(employee);

	}

}
