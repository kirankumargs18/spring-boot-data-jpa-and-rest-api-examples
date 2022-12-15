package com.globallogic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.entity.Product;
import com.globallogic.exception.IdNotFoundException;
import com.globallogic.service.ProductService;
import com.globallogic.utils.ProductConstants;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {

		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

	}

	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {

		return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = ProductConstants.ID) long id) {

		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = ProductConstants.ID) long id,
			@RequestBody Product product) {

		return new ResponseEntity<>(productService.updateProductById(id, product), HttpStatus.OK);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable(value = ProductConstants.ID) long id) {

		productService.deleteProductById(id);
		return new ResponseEntity<>(ProductConstants.DELETE_MESSAGE, HttpStatus.OK);
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> idNotFoundException(IdNotFoundException exception) {

		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
