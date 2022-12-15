package com.globallogic.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.globallogic.entity.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product addProduct(Product product);
	
	Product getProductById(ObjectId id);
	
	Product updateproductById(ObjectId id,Product product);
	
	void deleteProductById(ObjectId id);

}
