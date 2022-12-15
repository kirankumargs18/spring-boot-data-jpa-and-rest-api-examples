package com.globallogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globallogic.repository.LaptopRepository;

@SpringBootApplication
public class SpringDataJpaCustomQueriesApplication implements CommandLineRunner {

	@Autowired
	private LaptopRepository laptopRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaCustomQueriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\nGet ALl Laptops : ");
		laptopRepository.findAll().forEach(System.out::println);

		// name has to be passed like %name%
		System.out.println("\nFind By Name like : ");
		laptopRepository.findByNameLike("%Dell%").forEach(System.out::println);

		System.out.println("\nFind By Name Containing : ");
		laptopRepository.findByNameContaining("book").forEach(System.out::println);

		System.out.println("\nFind By Price GreaterThan : ");
		laptopRepository.findByPriceGreaterThan(70000).forEach(System.out::println);

		System.out.println("\nFind By Price LessThan : ");
		laptopRepository.findByPriceLessThan(70000).forEach(System.out::println);

		System.out.println("\nFind By Brand And Name : ");
		laptopRepository.findByBrandAndName("Dell", "Dell XPS").forEach(System.out::println);

	}

}
