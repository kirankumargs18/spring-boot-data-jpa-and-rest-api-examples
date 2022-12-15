package com.globallogic.service;

import java.util.List;

import com.globallogic.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product addProduct(Product product);

	Product getProductById(long id);

	Product updateProductById(long id, Product product);

	void deleteProductById(long id);

}
