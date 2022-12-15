package com.globallogic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.entity.Course;
import com.globallogic.service.CourseService;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public List<Course> getAllCourses() {

		return courseService.getAllCourses();
	}

	@PostMapping("/courses")
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {

		return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
	}

	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") long id) {

		return ResponseEntity.ok(courseService.getCourseById(id));

	}

	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") long id, @RequestBody Course course) {
		return new ResponseEntity<>(courseService.updateCourseById(id, course), HttpStatus.OK);
	}

	@DeleteMapping("/courses/{id}")
	public ResponseEntity<String> deleteCourseById(@PathVariable(value = "id") long id) {

		courseService.deleteCourseById(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

}
