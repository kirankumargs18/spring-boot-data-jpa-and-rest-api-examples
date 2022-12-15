package com.globallogic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
