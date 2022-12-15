package com.globallogic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.entity.Course;
import com.globallogic.exception.CourseNotFoundException;
import com.globallogic.repository.CourseRepository;
import com.globallogic.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	/*
	 * To get All courses
	 */
	@Override
	public List<Course> getAllCourses() {

		return courseRepository.findAll();
	}

	/*
	 * To create a course
	 */
	@Override
	public Course createCourse(Course course) {

		return courseRepository.save(course);
	}

	/*
	 * To get a course by id
	 */
	@Override
	public Course getCourseById(long id) {

		return courseRepository.findById(id)
				.orElseThrow(() -> new CourseNotFoundException("Course with ID : " + id + " not found"));

	}

	/*
	 * To update a course by id
	 */
	@Override
	public Course updateCourseById(long id, Course course) {

		Course newCourse = courseRepository.findById(id)
				.orElseThrow(() -> new CourseNotFoundException("Course with ID : " + id + " not found"));

		newCourse.setName(course.getName());
		newCourse.setPrice(course.getPrice());

		return courseRepository.save(newCourse);
	}

	/*
	 * To delete a course by id
	 */
	@Override
	public void deleteCourseById(long id) {

		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new CourseNotFoundException("Course with ID : " + id + " not found"));
		courseRepository.delete(course);
	}

}
