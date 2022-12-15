/**
 * @author kiran
 * */
package com.globallogic.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.entity.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, Long>  {
	
	

}
