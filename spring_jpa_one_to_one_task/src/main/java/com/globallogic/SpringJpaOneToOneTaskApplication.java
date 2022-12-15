package com.globallogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globallogic.dto.AddressDto;
import com.globallogic.dto.UserDto;
import com.globallogic.entity.Address;
import com.globallogic.entity.User;
import com.globallogic.repository.UserRepository;

@SpringBootApplication
public class SpringJpaOneToOneTaskApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOneToOneTaskApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * Address address=new Address();
	 * 
	 * address.setId(1l); address.setStreet("Kengeri");
	 * address.setCity("Bangalore"); address.setZipCode("560060");
	 * address.setState("Karnataka"); address.setCountry("India");
	 * 
	 * User user=new User();
	 * 
	 * user.setId(1l); user.setName("Kiran Kumar G S");
	 * user.setEmail("kiran@gmail.com"); user.setPassword("kiran");
	 * user.setAddress(address);
	 * 
	 * userRepository.save(user);
	 * 
	 * System.out.println(user);
	 * 
	 * 
	 * 
	 * }
	 */

}
