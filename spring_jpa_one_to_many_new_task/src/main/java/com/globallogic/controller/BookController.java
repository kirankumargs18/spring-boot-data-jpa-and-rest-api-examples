package com.globallogic.controller;

import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.dto.BookDto;
import com.globallogic.dto.PageDto;
import com.globallogic.service.BookService;
import com.globallogic.utils.AppConstants;

@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	private BookService bookService;

	/*
	 * Gets All Books from Database
	 */
	@GetMapping("/books")
	public ResponseEntity<List<BookDto>> getAllBooks() {

		return new ResponseEntity<List<BookDto>>(bookService.getAllBooks(), HttpStatus.OK);
	}

	/*
	 * Adds a Book to Database
	 */
	@PostMapping("/books")
	public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {

		return new ResponseEntity<BookDto>(bookService.addBook(bookDto), HttpStatus.CREATED);

	}

	/*
	 * Gets a Book from Database by using it's ID
	 */
	@GetMapping("/books/{id}")
	public ResponseEntity<BookDto> getBookById(@PathVariable(value = AppConstants.ID) long id) {

		return new ResponseEntity<BookDto>(bookService.getBookById(id), HttpStatus.OK);

	}

	/*
	 * Updates a Book by using it's ID
	 */
	@PutMapping("/books/{id}")
	public ResponseEntity<BookDto> updateBookById(@PathVariable(value = AppConstants.ID) long id,
			@RequestBody BookDto bookDto) {

		return new ResponseEntity<BookDto>(bookService.updateBookById(id, bookDto), HttpStatus.OK);

	}

	/*
	 * Deletes a Book by using it's ID
	 */
	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable(value = AppConstants.ID) long id) {

		bookService.deleteBookById(id);
		return new ResponseEntity<String>(AppConstants.DELETE_MESSAGE, HttpStatus.OK);
	}

	/*
	 * Gets a book by using it's title and author
	 */
	@GetMapping("/books/params")
	public ResponseEntity<List<BookDto>> getBookByTitleAndAuthor(@RequestParam(value = "title") String title,
			@RequestParam(value = "author") String author) {
		return new ResponseEntity<List<BookDto>>(bookService.getBookByTitleAndAuthor(title, author), HttpStatus.OK);
	}

	/*
	 * Gets Books by Title in Sorted Order by Author
	 */
	@GetMapping("/books/param")
	public ResponseEntity<List<BookDto>> getBooksByTitleSortedByTitle(@RequestParam(value = "title") String title) {
		return new ResponseEntity<List<BookDto>>(bookService.getBooksByTitleSortedByAuthor(title), HttpStatus.OK);
	}

}
