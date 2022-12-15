/**
 * @author kiran
 * */
package com.globallogic.service;

import java.util.List;

import com.globallogic.dto.PersonDto;

public interface PersonService {
	
	List<PersonDto> fetchAllPersons();
	
	PersonDto addPerson(PersonDto personDto);
	
	PersonDto fetchPersonById(Long id);
	
	PersonDto updatePersonById(Long id,PersonDto personDto);
	
	void deletePersonById(Long id);

}
