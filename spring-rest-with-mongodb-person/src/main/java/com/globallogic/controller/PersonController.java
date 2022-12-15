/**
 * @author kiran
 * */
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

import com.globallogic.dto.PersonDto;
import com.globallogic.service.PersonService;
import com.globallogic.utils.AppConstants;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	/**
	 * To Get All Persons from database
	 */
	@GetMapping
	public ResponseEntity<List<PersonDto>> fetchAllPersons() {

		return new ResponseEntity<>(personService.fetchAllPersons(), HttpStatus.OK);
	}

	/**
	 * To Save the Person to Database
	 */
	@PostMapping
	public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto personDto) {
		

		PersonDto personDto2=personDto;

		return new ResponseEntity<>(personService.addPerson(personDto), HttpStatus.CREATED);
	}

	/**
	 * To Get the Person from database
	 */
	@GetMapping("/{id}")
	public ResponseEntity<PersonDto> fetchPersonById(@PathVariable Long id) {

		return new ResponseEntity<>(personService.fetchPersonById(id), HttpStatus.OK);
	}

	/**
	 * To Update the Person
	 */
	@PutMapping("/{id}")
	public ResponseEntity<PersonDto> updatePersonById(@PathVariable Long id, @RequestBody PersonDto personDto) {
		

		return new ResponseEntity<>(personService.updatePersonById(id, personDto), HttpStatus.OK);
	}

	/**
	 * To Delete the Person from database
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePersonById(@PathVariable Long id) {

		personService.deletePersonById(id);

		return new ResponseEntity<>(AppConstants.DELETE_MESSAGE, HttpStatus.OK);
	}

}
