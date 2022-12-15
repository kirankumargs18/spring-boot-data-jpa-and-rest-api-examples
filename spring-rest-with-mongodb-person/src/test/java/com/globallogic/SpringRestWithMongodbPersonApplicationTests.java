package com.globallogic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.globallogic.entity.Address;
import com.globallogic.entity.Gender;
import com.globallogic.entity.Person;
import com.globallogic.repository.PersonRepository;
import com.globallogic.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringRestWithMongodbPersonApplicationTests {

	@Autowired
	private PersonService personService;

	@MockBean
	private PersonRepository personRepository;

	@Test
	public void getAllPersonsTest() {

		List<Person> persons = new ArrayList<>();

		Person person = new Person();
		Address address = new Address();

		person.setId(1l);
		person.setFirstName("Naveen");
		person.setLastName("Kumar G S");
		person.setAge(23);
		person.setGender(Gender.MALE);

		address.setArea("Kengeri");
		address.setCity("Bangalore");
		address.setState("Karnataka");

		person.setAddress(address);

		Person person1 = new Person();
		Address address1 = new Address();

		person1.setId(1l);
		person1.setFirstName("Shravan");
		person1.setLastName("Kumar G S");
		person1.setAge(23);
		person1.setGender(Gender.MALE);

		address1.setArea("Kolar");
		address1.setCity("Kolar");
		address1.setState("Karnataka");

		person.setAddress(address1);

		persons.add(person);
		persons.add(person1);

		when(personRepository.findAll()).thenReturn(Arrays.asList(person, person1));
		assertEquals(2, personService.fetchAllPersons());

	}
}
