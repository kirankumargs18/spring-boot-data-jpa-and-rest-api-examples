/**
 * @author kiran
 * */
package com.globallogic.service;

import java.util.List;

import com.globallogic.dto.BookDto;

public interface BookService {

	List<BookDto> fetchAllBooks();

	BookDto addBook(BookDto bookDto);

	BookDto fetchBookById(Long id);

	BookDto updateBookById(Long id, BookDto bookDto);

	void deleteBookById(Long id);

}
