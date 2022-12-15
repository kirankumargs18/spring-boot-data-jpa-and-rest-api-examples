package com.globallogic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globallogic.entity.Address;
import com.globallogic.entity.Gender;
import com.globallogic.entity.Student;
import com.globallogic.repository.StudentRepository;

@SpringBootApplication
public class SpringRestWithMongodbApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestWithMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Student student = new Student();

		Address address = new Address();
		address.setArea("Kolar");
		address.setCity("Kolar");
		address.setState("Karntaka");

		student.setId("1");
		student.setFirstName("Naveen");
		student.setLastName("G S");
		student.setEmail("naveen@gmail.com");
		student.setGender(Gender.MALE);
		student.setAddress(address);
		student.setSubjects(List.of("Python","C"));
		
		studentRepository.save(student);
		System.out.println("Inserted");

	

	}

}
