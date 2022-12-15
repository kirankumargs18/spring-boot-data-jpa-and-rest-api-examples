package com.globallogic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.entity.Instructor;
import com.globallogic.entity.InstructorDetail;
import com.globallogic.exception.ResourceNotFoundException;
import com.globallogic.repository.InstructorRepository;
import com.globallogic.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public List<Instructor> getAllInstructors() {

		return instructorRepository.findAll();
	}

	@Override
	public Instructor getInstructorById(long id) {

		return instructorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found with ID : " + id));
		
	}

	@Override
	public Instructor createInstructor(Instructor instructor) {

		return instructorRepository.save(instructor);
	}

	@Override
	public Instructor updateInstructor(long id, Instructor instructor) {

		Instructor newInstructor = instructorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found with ID : " + id));

		newInstructor.setId(instructor.getId());
		newInstructor.setFirstName(instructor.getFirstName());
		newInstructor.setLastName(instructor.getLastName());
		newInstructor.setInstructorDetail(instructor.getInstructorDetail());

		return instructorRepository.save(newInstructor);
	}

	@Override
	public void deleteInstructor(long id) {

		Instructor instructor = instructorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id : " + id));

		instructorRepository.delete(instructor);
	}

}
