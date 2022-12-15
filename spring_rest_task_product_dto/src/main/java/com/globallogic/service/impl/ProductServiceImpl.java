package com.globallogic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.dto.ProductDto;
import com.globallogic.entity.Product;
import com.globallogic.exception.IdNotFoundException;
import com.globallogic.exception.InvalidPriceException;
import com.globallogic.repository.ProductRepository;
import com.globallogic.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	/*
	 * @Description : To get all ProductDTOs
	 * 
	 * @Returns : It returns List of ProductDTOs
	 * 
	 * @createdBy : Kiran Kumar G S
	 * 
	 * @CreatedDate : 02/11/2022
	 */
	@Override
	public List<ProductDto> getAllProducts() {

		List<Product> products = productRepository.findAll();
		return products.stream().map(product -> convertToDto(product)).collect(Collectors.toList());
	}

	/*
	 * @Description : To add Product into database
	 * 
	 * @Returns : It returns ProductDTO which has been added
	 * 
	 * @Params : It takes ProductDTO as parameter
	 * 
	 * @createdBy : Kiran Kumar G S
	 * 
	 * @CreatedDate : 02/11/2022
	 */
	@Override
	public ProductDto addProduct(ProductDto productDto) {

		double price = productDto.getPrice();
		if (price <= 0) {
			throw new InvalidPriceException("Price cannot be zero");
		}

		Product product = converToEntity(productDto);
		return convertToDto(productRepository.save(product));
	}

	/*
	 * @Description : To get Product by using it's id
	 * 
	 * @Returns : It returns ProductDTO
	 * 
	 * @Params : It takes Product ID as parameter
	 * 
	 * @createdBy : Kiran Kumar G S
	 * 
	 * @CreatedDate : 02/11/2022
	 */
	@Override
	public ProductDto getProductById(long id) {

		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isEmpty()) {
			throw new IdNotFoundException("Product not found with ID : " + id);
		}
		return convertToDto(optionalProduct.get());
	}

	/*
	 * @Description : To update Product by using it's id
	 * 
	 * @Returns : It returns Updated ProductDTO
	 * 
	 * @Params : It takes Product ID and ProductDTO as parameters
	 * 
	 * @createdBy : Kiran Kumar G S
	 * 
	 * @CreatedDate : 02/11/2022
	 */
	@Override
	public ProductDto updateProductById(long id, ProductDto productDto) {

		Product product = productRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Product with Id : " + id + " is not found"));

		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setCategory(productDto.getCategory());

		Product upatedProduct = productRepository.save(product);

		return convertToDto(upatedProduct);
	}

	/*
	 * @Description : To delete Product by using it's id
	 * 
	 * @Params : It takes Product ID as parameter
	 * 
	 * @createdBy : Kiran Kumar G S
	 * 
	 * @CreatedDate : 02/11/2022
	 */
	@Override
	public void deleteProductById(long id) {

		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isEmpty()) {
			throw new IdNotFoundException("Product not found with ID : " + id);
		}
		productRepository.delete(optionalProduct.get());
	}

	/*
	 * It Converts Product Entity to Product DTO
	 */
	private ProductDto convertToDto(Product product) {

		/*
		 * ProductDto productDto = new ProductDto();
		 * 
		 * productDto.setId(product.getId()); productDto.setName(product.getName());
		 * productDto.setCategory(product.getCategory());
		 * productDto.setPrice(product.getPrice());
		 */

		// chaging to use Model Mapper
		// ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(product, ProductDto.class);
	}

	/*
	 * It Converts Product DTO to Product Entity
	 */
	private Product converToEntity(ProductDto productDto) {

		/*
		 * Product product = new Product();
		 * 
		 * product.setId(productDto.getId()); product.setName(productDto.getName());
		 * product.setCategory(productDto.getCategory());
		 * product.setPrice(productDto.getPrice());
		 */

		return modelMapper.map(productDto, Product.class);
	}

}
