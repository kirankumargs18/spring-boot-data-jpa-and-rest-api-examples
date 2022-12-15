package com.globallogic.service;

import java.util.List;

import com.globallogic.entity.Instructor;

public interface InstructorService {

	List<Instructor> getAllInstructors();

	Instructor getInstructorById(long id);

	Instructor createInstructor(Instructor instructor);

	Instructor updateInstructor(long id, Instructor instructor);

	void deleteInstructor(long id);

}
