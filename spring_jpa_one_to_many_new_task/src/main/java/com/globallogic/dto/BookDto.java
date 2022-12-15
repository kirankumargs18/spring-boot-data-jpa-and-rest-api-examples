package com.globallogic.dto;

import java.util.Set;

public class BookDto {

	private Long id;

	private String title;

	private String author;

	private String isbn;

	private Set<PageDto> pages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<PageDto> getPages() {
		return pages;
	}

	public void setPages(Set<PageDto> pages) {
		this.pages = pages;
	}

}
