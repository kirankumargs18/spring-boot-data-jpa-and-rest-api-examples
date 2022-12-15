/**
 * @author kiran
 * */
package com.globallogic.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.dto.AddressDto;
import com.globallogic.dto.PersonDto;
import com.globallogic.entity.Address;
import com.globallogic.entity.Gender;
import com.globallogic.entity.Person;
import com.globallogic.exception.ResourceNotFoundException;
import com.globallogic.repository.PersonRepository;
import com.globallogic.service.PersonService;
import com.globallogic.utils.AppConstants;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	/**
	 * @description : Fetches All Persons from Database
	 * @return List<personDto> : List of Persons
	 */
	@Override
	public List<PersonDto> fetchAllPersons() {

		return personRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	/**
	 * @description : Saves the Person to Database
	 * @param personDto : Person to be saved into database
	 * @return personDto : Saved Person
	 */
	@Override
	public PersonDto addPerson(PersonDto personDto) {

		return convertToDto(personRepository.insert(convertToEntity(personDto)));
	}

	/**
	 * @description : Fetches the Person by using his ID
	 * @param id : ID of the Person to be fetched
	 * @return personDto : Person matching the passed ID
	 * @throws ResourceNotFoundException : If Person with given ID not found
	 */
	@Override
	public PersonDto fetchPersonById(Long id) {

		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.RESOURCE_NOT_FOUND_MESSAGE + id));

		return convertToDto(person);
	}

	/**
	 * @description : Updates the Person by using his ID
	 * @param id, personDto : ID and Person to be updated
	 * @return personDto : Updated Person
	 * @throws ResourceNotFoundException : If Person with passed ID not found
	 */
	@Override
	public PersonDto updatePersonById(Long id, PersonDto personDto) {

		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.RESOURCE_NOT_FOUND_MESSAGE + id));

		Address address = person.getAddress();

		address.setArea(personDto.getAddressDto().getArea());
		address.setCity(personDto.getAddressDto().getCity());
		address.setState(personDto.getAddressDto().getState());

		person.setId(personDto.getId());
		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setGender(personDto.getGender());
		person.setAddress(address);
		person.setAge(personDto.getAge());

		return convertToDto(personRepository.save(person));
	}

	/**
	 * @description : Deletes the Person by using his ID
	 * @param id : ID of the Person to be Deleted
	 * @throws ResourceNotFoundException : If Person with given ID not found
	 */
	@Override
	public void deletePersonById(Long id) {

		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.RESOURCE_NOT_FOUND_MESSAGE + id));
		personRepository.delete(person);

	}

	/**
	 * @description : Helper Method which converts Entity to DTO
	 * @param person : Person Entity to be converted into Person DTO
	 * @return personDto : Person DTO
	 */
	private PersonDto convertToDto(Person person) {

		AddressDto addressDto = new ModelMapper().map(person.getAddress(), AddressDto.class);
		PersonDto personDto = new ModelMapper().map(person, PersonDto.class);
		personDto.setAddressDto(addressDto);
		return personDto;

	}

	/**
	 * @description : Helper Method which converts DTO to Entity
	 * @param personDto : Person DTO to be converted into Person Entity
	 * @return person : Person Entity
	 */
	private Person convertToEntity(PersonDto personDto) {

		Address address = new ModelMapper().map(personDto.getAddressDto(), Address.class);
		Person person = new ModelMapper().map(personDto, Person.class);
		person.setAddress(address);
		return person;
	}
	

}
