package com.globallogic.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.globallogic.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {

}
