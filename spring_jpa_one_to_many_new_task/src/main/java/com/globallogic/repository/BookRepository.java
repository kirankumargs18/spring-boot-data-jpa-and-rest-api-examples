package com.globallogic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.globallogic.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(value = "select b from Book b where b.title=?1 and b.author=?2")
	List<Book> findByTitleAndAuthor(String title, String author);

	List<Book> findByTitleOrderByAuthorAsc(String title);
	

}
