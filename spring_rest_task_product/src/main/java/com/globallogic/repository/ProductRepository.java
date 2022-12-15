package com.globallogic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
