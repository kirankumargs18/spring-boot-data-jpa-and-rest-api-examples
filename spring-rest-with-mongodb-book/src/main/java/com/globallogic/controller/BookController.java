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

import com.globallogic.dto.BookDto;
import com.globallogic.service.BookService;
import com.globallogic.utils.AppConstants;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * Fetches All Books
	 * */
	@GetMapping
	public ResponseEntity<List<BookDto>> fetchAllBooks() {

		return new ResponseEntity<>(bookService.fetchAllBooks(), HttpStatus.OK);
	}

	/**
	 * Saves a Book 
	 * */
	@PostMapping
	public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {

		return new ResponseEntity<BookDto>(bookService.addBook(bookDto), HttpStatus.CREATED);
	}

	/**
	 * Fetches a Book by using it's ID
	 * */
	@GetMapping("/{id}")
	public ResponseEntity<BookDto> fetchBookById(@PathVariable Long id) {

		return new ResponseEntity<BookDto>(bookService.fetchBookById(id), HttpStatus.OK);
	}

	/**
	 * Updates a Book By using it's ID
	 * */
	@PutMapping("/{id}")
	public ResponseEntity<BookDto> updateBookById(@PathVariable Long id, @RequestBody BookDto bookDto) {

		return new ResponseEntity<BookDto>(bookService.updateBookById(id, bookDto), HttpStatus.OK);
	}

	/**
	 * Deletes a Book using it's ID
	 * */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable Long id) {
		
		bookService.deleteBookById(id);
		return new ResponseEntity<String>(AppConstants.DELETE_MESSAGE, HttpStatus.OK);
	}

}
