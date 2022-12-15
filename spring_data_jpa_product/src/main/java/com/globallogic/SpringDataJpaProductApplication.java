package com.globallogic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globallogic.entity.Product;
import com.globallogic.repository.ProductRepository;

@SpringBootApplication
public class SpringDataJpaProductApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {

		SpringApplication.run(SpringDataJpaProductApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// Insert product

		Product product = new Product();

		product.setId(7);
		product.setName("Redmi Mobile");
		product.setCategory("Mobiles");
		product.setPrice(15999.00f);

		productRepository.save(product);

		// Retrieve : Get product where id=2

		Product product1 = productRepository.findById(2).get();
		System.out.println("Product with ID " + product1.getId() + " : " + product1);

		// update : set product price = 2500 where id=2

		Product product2 = productRepository.findById(4).get();
		product2.setPrice(500.00f);
		productRepository.save(product2);
		System.out.println("Updated product with id : " + product2.getId());

		// delete

		productRepository.deleteById(7);
		System.out.println("Deleted product");

		// get all products in DB

		List<Product> products = productRepository.findAll();
		System.out.println("Products : ");
		products.forEach(System.out::println);

		// find by name

		System.out.println("Find By Name : ");
		Product product3 = productRepository.findByName("Oneplus 9");
		System.out.println(product3);

		// find by name and id

		System.out.println("Find By Id and Name");
		Product product4 = productRepository.findByIdAndName(3, "Shoes");
		System.out.println(product4);

		// find all sorted by id
		System.out.println("Products By Id sorted in descending order : ");
		List<Product> productsSortedById = productRepository.findAllSortedById();
		productsSortedById.forEach(System.out::println);

		// find all by category
		System.out.println("Products By Category : ");
		List<Product> productsByCategory = productRepository.findAllByCategory("Electronics");
		productsByCategory.forEach(System.out::println);

		// find price by name
		System.out.println("Getting price by passing name : ");
		Float price = productRepository.findPriceByName("Oneplus 9");
		System.out.println("Price : "+price);

	}

}
