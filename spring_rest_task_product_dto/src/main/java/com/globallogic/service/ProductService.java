package com.globallogic.service;

import java.util.List;

import com.globallogic.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProducts();

	ProductDto addProduct(ProductDto productDto);

	ProductDto getProductById(long id);

	ProductDto updateProductById(long id, ProductDto productDto);

	void deleteProductById(long id);

}
