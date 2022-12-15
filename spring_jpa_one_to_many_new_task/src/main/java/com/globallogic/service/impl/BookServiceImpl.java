package com.globallogic.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.dto.BookDto;
import com.globallogic.dto.PageDto;
import com.globallogic.entity.Book;
import com.globallogic.entity.Page;
import com.globallogic.exception.IdNotFoundException;
import com.globallogic.repository.BookRepository;
import com.globallogic.service.BookService;
import com.globallogic.utils.AppConstants;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	/*
	 * @Description : To get all BookDTOs
	 * @Returns : It returns List of BookDTOs
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 04/11/2022
	 */
	@Override
	public List<BookDto> getAllBooks() {

		return bookRepository.findAll().stream().map((book) -> convertToDto(book)).collect(Collectors.toList());

	}


	/*
	 * @Description : To add Book into database
	 * @Returns : It returns BookDTO which has been added
	 * @Params : It takes BookDTO as parameter
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 04/11/2022
	 */
	@Override
	public BookDto addBook(BookDto bookDto) {

		return convertToDto(bookRepository.save(convertToEntity(bookDto)));
	}

	/*
	 * @Description : To get Book by using it;s id
	 * @Returns : It returns BookDTO
	 * @Params : It takes Book ID as parameter
	 * @Throws : IdNotFoundException if Book not found
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 04/11/2022
	 */
	@Override
	public BookDto getBookById(long id) {

		return convertToDto(bookRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException(AppConstants.NOT_FOUND_MESSAGE + id)));
	}

	/*
	 * @Description : To update Book by using it's id
	 * @Returns : It returns Updated BookDTO
	 * @Params : It takes Book ID and BookDTO as parameters
	 * @Throws : IdNotFoundException if Book not found
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 04/11/2022
	 */
	@Override
	public BookDto updateBookById(long id, BookDto bookDto) {

		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException(AppConstants.NOT_FOUND_MESSAGE + id));

		Set<Page> pages = new HashSet<>();
		
		book.setId(bookDto.getId());
		book.setTitle(bookDto.getTitle());
		book.setAuthor(bookDto.getAuthor());
		book.setIsbn(bookDto.getIsbn());
		Set<PageDto> pageDtos = bookDto.getPages();

		for (PageDto pageDto : pageDtos) {

			Page page = new Page();
			page.setId(pageDto.getId());
			page.setNumber(pageDto.getNumber());
			page.setChapter(pageDto.getChapter());
			page.setContent(pageDto.getContent());
			page.setBook(book);
			pages.add(page);
		}
		book.setPages(pages);

		return convertToDto(bookRepository.save(book));
	}

	/*
	 * @Description : To delete Book by using it's id
	 * @Params : It takes Book ID as parameter
	 * @Throws : IdNotFoundException if Book not found
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 04/11/2022
	 */
	@Override
	public void deleteBookById(long id) {

		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException(AppConstants.NOT_FOUND_MESSAGE + id));
		bookRepository.delete(book);

	}
	

	
	

	/*
	 * Helper Method which Converts Entity to DTO
	 */
	private BookDto convertToDto(Book book) {

		BookDto bookDto = new BookDto();
		Set<PageDto> pageDtos = new HashSet<>();

		bookDto.setId(book.getId());
		bookDto.setTitle(book.getTitle());
		bookDto.setAuthor(book.getAuthor());
		bookDto.setIsbn(book.getIsbn());
		
		Set<Page> pages = book.getPages();

		for (Page page : pages) {

			PageDto pageDto = new PageDto();
			pageDto.setId(page.getId());
			pageDto.setNumber(page.getNumber());
			pageDto.setChapter(page.getChapter());
			pageDto.setContent(page.getContent());

			pageDtos.add(pageDto);

		}
		bookDto.setPages(pageDtos);

		return bookDto;
	}

	/*
	 * Helper Method which Converts DTO to Entity
	 */
	private Book convertToEntity(BookDto bookDto) {

		Book book = new Book();
		Set<Page> pages = new HashSet<>();
		
		book.setId(bookDto.getId());
		book.setTitle(bookDto.getTitle());
		book.setAuthor(bookDto.getAuthor());
		book.setIsbn(bookDto.getIsbn());
		Set<PageDto> pageDtos = bookDto.getPages();

		for (PageDto pageDto : pageDtos) {

			Page page = new Page();
			page.setId(pageDto.getId());
			page.setNumber(pageDto.getNumber());
			page.setChapter(pageDto.getChapter());
			page.setContent(pageDto.getContent());
			page.setBook(book);
			pages.add(page);
		}
		book.setPages(pages);

		return book;

	}


	@Override
	public List<BookDto> getBookByTitleAndAuthor(String title, String author) {

		return bookRepository.findByTitleAndAuthor(title, author).stream().map(this::convertToDto)
				.collect(Collectors.toList());
	}


	@Override
	public List<BookDto> getBooksByTitleSortedByAuthor(String title) {

		return bookRepository.findByTitleOrderByAuthorAsc(title).stream().map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
}
