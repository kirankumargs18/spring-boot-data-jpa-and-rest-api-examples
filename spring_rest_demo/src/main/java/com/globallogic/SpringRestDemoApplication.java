package com.globallogic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globallogic.entity.Course;
import com.globallogic.entity.Employee;
import com.globallogic.repository.CourseRepository;
import com.globallogic.repository.EmployeeRepository;

@SpringBootApplication
public class SpringRestDemoApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Course course1 = new Course(1, "Java Programming", 1999.00f);
		Course course2 = new Course(2, "Python Programming", 2999.00f);
		Course course3 = new Course(3, "The Spring Framework", 3999.00f);
		Course course4 = new Course(4, "Rest API Development", 4999.00f);

		courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4));
		System.out.println("Inserted into course");
		
		Employee employee=new Employee(1, "kira", "Dev", 45000, 24);
		
		employeeRepository.save(employee);
		

	}

}
