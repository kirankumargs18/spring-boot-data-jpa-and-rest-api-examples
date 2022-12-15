package com.globallogic.service;

import java.util.List;

import com.globallogic.entity.Course;

public interface CourseService {

	List<Course> getAllCourses();

	Course createCourse(Course course);

	Course getCourseById(long id);

	Course updateCourseById(long id, Course course);

	void deleteCourseById(long id);

}
