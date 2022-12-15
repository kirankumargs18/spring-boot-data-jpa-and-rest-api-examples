package com.globallogic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.entity.Student;
import com.globallogic.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		
		return new ResponseEntity<List<Student>>(studentRepository.findAll(), HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/{sno}") public ResponseEntity<Student>
	 * getStudentById(@PathVariable String sno){ return new
	 * ResponseEntity<Student>(studentRepository.findBySno(sno).get(),
	 * HttpStatus.OK); }
	 */
	
	
	

}
