package com.globallogic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.globallogic.entity.Product;
import com.globallogic.repository.ProductRepository;
import com.globallogic.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringRestTaskProductApplicationTests {

	@Autowired
	private ProductService productService;

	@MockBean
	private ProductRepository productRepository;

	/**
	 * Tests get all products
	 */
	@Test
	public void testGetAllProducts() {

		List<Product> products = new ArrayList<>();
		products.add(new Product(11L, "Mouse", "Electronice", 999));
		products.add(new Product(12l, "Mobile", "Mobiles", 9999));

		//when(productRepository.findAll()).thenReturn(products);
		//assertEquals(2, productService.getAllProducts().size());
		
		when(productRepository.findAll()).thenReturn(products);
		assertEquals(2, productService.getAllProducts().size());
	}

	/**
	 * Tests get product by ID
	 */
	@Test
	public void testGetProductById() {

		Long id = 11L;
		Optional<Product> product = Optional.of(new Product(11L, "Mouse", "Electronice", 999));

		when(productRepository.findById(id)).thenReturn(product);
		assertEquals(productService.getProductById(id), product.get());
	}

	/**
	 * Tests add Product
	 */
	@Test
	public void testAddProduct() {

		Product product = new Product(13l, "Mobile", "Electronics", 14999);

		when(productRepository.save(product)).thenReturn(product);
		assertEquals(productService.addProduct(product), product);
	}

	/**
	 * Tests update product
	 */
	@Test
	public void testUpdateProductById() {

		Long id=14l;
		Optional<Product> product = Optional.of(new Product(14l, "Laptop", "Electronics", 79999));

		when(productRepository.findById(id)).thenReturn(product);
		Product updatedProduct = new Product(14l, "HP Laptop", "Electronics", 79999);
		when(productRepository.save(updatedProduct)).thenReturn(updatedProduct);
		when(productService.updateProductById(14l, updatedProduct)).thenReturn(updatedProduct);
		assertEquals(productService.updateProductById(14l, updatedProduct), updatedProduct);
	}

	/**
	 * Tests deletes product
	 */
	@Test
	public void testDeleteProductById() {
		
		Optional<Product> product1 = Optional.of(new Product(13l, "Mobile", "Electronics", 14999));
		when(productRepository.findById(13l)).thenReturn(product1);
		productService.deleteProductById(product1.get().getId());
	}
	

}
