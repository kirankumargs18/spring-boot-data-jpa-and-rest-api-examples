package com.globallogic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

	List<Laptop> findByNameLike(String name);

	List<Laptop> findByNameContaining(String name);
	
	List<Laptop> findByPriceGreaterThan(double price);
	
	List<Laptop> findByPriceLessThan(double price);
	
	List<Laptop> findByBrandAndName(String brand,String name);


	/**
	 * Refer official documentation for more such queries
	 * */
}
