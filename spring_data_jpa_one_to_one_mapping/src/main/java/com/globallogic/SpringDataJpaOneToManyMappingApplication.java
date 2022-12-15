package com.globallogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globallogic.entity.Employee;
import com.globallogic.entity.Project;
import com.globallogic.repository.EmployeeRepository;

@SpringBootApplication
public class SpringDataJpaOneToManyMappingApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaOneToManyMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Employee employee = new Employee();
		employee.setId(101);
		employee.setName("Kiran Kumar G S");

		List<Project> projects = new ArrayList<>();

		Project project1 = new Project();
		project1.setId(10);
		project1.setName("Spring boot REST");

		Project project2 = new Project();
		project2.setId(11);
		project2.setName("Spring boot MVC");

		projects.addAll(Arrays.asList(project1, project2));

		employee.setProjects(projects);

		employeeRepository.save(employee);

	}

}
