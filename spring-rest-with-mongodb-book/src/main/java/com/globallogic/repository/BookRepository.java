/**
 * @author kiran
 * */
package com.globallogic.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.entity.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Long> {

}
