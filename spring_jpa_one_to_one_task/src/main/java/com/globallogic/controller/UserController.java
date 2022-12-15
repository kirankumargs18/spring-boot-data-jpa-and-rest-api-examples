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

import com.globallogic.dto.UserDto;
import com.globallogic.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * Gets all users from database
	 * */
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers() {

		return new ResponseEntity<List<UserDto>>(userService.getAllUsers(), HttpStatus.OK);
	}

	/*
	 * Gets a User by his id 
	 * */
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable(value = "id") long id) {

		return new ResponseEntity<UserDto>(userService.getUserById(id), HttpStatus.OK);
	}

	/*
	 * Saves User to database
	 * */
	@PostMapping("/users")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {

		return new ResponseEntity<UserDto>(userService.addUser(userDto), HttpStatus.CREATED);

	}

	/*
	 * Updates User by his id
	 * */
	@PutMapping("/users/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable(value = "id") long id, @RequestBody UserDto userDto) {

		return new ResponseEntity<UserDto>(userService.updateUserById(id, userDto), HttpStatus.OK);
	}

	/*
	 * Deletes a User by his id
	 * */
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") long id) {

		userService.deleteUserById(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	/*
	 * Gets All Pages From a Book
	 * */

}
