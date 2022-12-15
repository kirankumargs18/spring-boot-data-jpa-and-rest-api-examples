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

import com.globallogic.entity.Instructor;
import com.globallogic.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

	@Autowired
	InstructorService instructorService;

	@GetMapping
	public List<Instructor> getAllInstructors() {

		return instructorService.getAllInstructors();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Instructor> getInstructorById(@PathVariable(value = "id") long id) {

		return ResponseEntity.ok(instructorService.getInstructorById(id));

	}

	@PostMapping
	public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {

		return new ResponseEntity<>(instructorService.createInstructor(instructor), HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable(name = "id") long id,
			@RequestBody Instructor instructor) {

		return new ResponseEntity<>(instructorService.updateInstructor(id, instructor), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInstructor(@PathVariable(name = "id") long id) {

		instructorService.deleteInstructor(id);

		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

	}

}
