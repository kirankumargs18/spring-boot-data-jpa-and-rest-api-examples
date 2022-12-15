/**
 * @author kiran
 * */
package com.globallogic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.dto.BookDto;
import com.globallogic.dto.PageDto;
import com.globallogic.entity.Book;
import com.globallogic.entity.Page;
import com.globallogic.exception.ResourceNotFoundException;
import com.globallogic.repository.BookRepository;
import com.globallogic.service.BookService;
import com.globallogic.utils.AppConstants;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * @description : Fetches All Books from Database
	 * @return List<bookDto> : List of Books
	 */
	@Override
	public List<BookDto> fetchAllBooks() {

		return bookRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	/**
	 * @description : Saves the Book to Database
	 * @param bookDto : Book to be saved into database
	 * @return bookDto : Saved Book
	 */
	@Override
	public BookDto addBook(BookDto bookDto) {

		return convertToDto(bookRepository.insert(convertToEntity(bookDto)));
	}

	/**
	 * @description : Fetches the Book by using it's ID
	 * @param id : ID of the Book to be fetched
	 * @return bookDto : Book matching the passed ID
	 * @throws ResourceNotFoundException : If Book with given ID not found
	 */
	@Override
	public BookDto fetchBookById(Long id) {

		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND_MESSAGE + id));
		return convertToDto(book);
	}

	/**
	 * @description : Updates the Book by using it's ID
	 * @param id, bookDto : ID and Book to be updated
	 * @return bookDto : Updated Book
	 * @throws ResourceNotFoundException : If Book with passed ID not found
	 */
	@Override
	public BookDto updateBookById(Long id, BookDto bookDto) {

		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND_MESSAGE + id));

		book.setTitle(bookDto.getTitle());
		book.setAuthor(bookDto.getAuthor());
		book.setIsbn(bookDto.getIsbn());

		List<Page> pages = new ArrayList<>();

		for (PageDto pageDto : bookDto.getPages()) {
			Page page = new Page();
			page.setPageNumber(pageDto.getPageNumber());
			page.setTopic(pageDto.getTopic());
			pages.add(page);
		}
		book.setPages(pages);

		return convertToDto(bookRepository.save(book));
	}

	/**
	 * @description : Deletes the Book by using it's ID
	 * @param id : ID of the Book to be Deleted
	 * @throws ResourceNotFoundException : If Book with given ID not found
	 */
	@Override
	public void deleteBookById(Long id) {

		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND_MESSAGE + id));
		bookRepository.delete(book);

	}

	/**
	 * @description : Helper Method which converts Entity to DTO
	 * @param book : Book Entity to be converted into Book DTO
	 * @return bookDto : Book DTO
	 */
	private BookDto convertToDto(Book book) {

		BookDto bookDto = new BookDto();
		List<PageDto> pageDtos = new ArrayList<>();

		for (Page page : book.getPages()) {

			PageDto pageDto = new ModelMapper().map(page, PageDto.class);
			pageDtos.add(pageDto);

		}
		bookDto = new ModelMapper().map(book, BookDto.class);
		bookDto.setPages(pageDtos);

		return bookDto;
	}

	/**
	 * @description : Helper Method which converts DTO to Entity
	 * @param bookDto : Book DTO to be converted into Book Entity
	 * @return book : Book Entity
	 */
	private Book convertToEntity(BookDto bookDto) {

		Book book = new Book();
		List<Page> pages = new ArrayList<>();

		book = new ModelMapper().map(bookDto, Book.class);
		for (PageDto pageDto : bookDto.getPages()) {

			Page page = new ModelMapper().map(pageDto, Page.class);
			pages.add(page);
		}
		book.setPages(pages);

		return book;
	}
}
