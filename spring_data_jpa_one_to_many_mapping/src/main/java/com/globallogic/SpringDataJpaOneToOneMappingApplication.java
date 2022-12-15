package com.globallogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globallogic.entity.Instructor;
import com.globallogic.entity.InstructorDetail;
import com.globallogic.repository.InstructorRepository;

@SpringBootApplication
public class SpringDataJpaOneToOneMappingApplication implements CommandLineRunner {

	@Autowired
	private InstructorRepository instructorRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaOneToOneMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Instructor instructor = new Instructor();
		instructor.setId(1l);
		instructor.setFirstName("Kiran Kumar");
		instructor.setLastName("G S");

		InstructorDetail instructorDetail = new InstructorDetail(1l, "Easy Way to Learn", "Cricket");

		instructor.setInstructorDetail(instructorDetail);

		instructorRepository.save(instructor);
		System.out.println("Inserted");

	}

}
