package com.globallogic.service;

import java.util.List;
import java.util.Set;

import com.globallogic.dto.BookDto;
import com.globallogic.dto.PageDto;

public interface BookService {

	List<BookDto> getAllBooks();

	BookDto addBook(BookDto bookDto);

	BookDto getBookById(long id);

	BookDto updateBookById(long id, BookDto bookDto);

	void deleteBookById(long id);

	List<BookDto> getBookByTitleAndAuthor(String title, String author);
	
	List<BookDto> getBooksByTitleSortedByAuthor(String title);

}
