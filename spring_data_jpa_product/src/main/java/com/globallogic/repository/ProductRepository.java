package com.globallogic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.globallogic.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	// find by name
	Product findByName(String name);

	// find by id and name
	Product findByIdAndName(int id, String name);

	// find all sorted by id
	@Query(value = "select * from products order by id desc", nativeQuery = true)
	List<Product> findAllSortedById();

	// find all by category
	@Query(value = "select * from products where category =?1", nativeQuery = true)
	List<Product> findAllByCategory(String category);

	// find price by product name
	@Query(value = "select price from products where name =?1", nativeQuery = true)
	float findPriceByName(String name);

}
