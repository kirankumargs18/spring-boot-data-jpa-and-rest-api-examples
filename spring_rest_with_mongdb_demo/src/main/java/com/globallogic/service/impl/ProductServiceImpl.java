package com.globallogic.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.entity.Product;
import com.globallogic.repository.ProductRepository;
import com.globallogic.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {

		return null;
	}

	@Override
	public Product getProductById(ObjectId id) {

		return null;
	}

	@Override
	public Product updateproductById(ObjectId id, Product product) {

		return null;
	}

	@Override
	public void deleteProductById(ObjectId id) {

	}

}
