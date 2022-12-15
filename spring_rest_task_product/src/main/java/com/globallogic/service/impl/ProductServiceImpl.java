package com.globallogic.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.entity.Product;
import com.globallogic.exception.IdNotFoundException;
import com.globallogic.exception.InvalidPriceException;
import com.globallogic.repository.ProductRepository;
import com.globallogic.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	Log log = LogFactory.getLog(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	/**
	 * @Description : To get all Products
	 * @Returns : It returns List of Products
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 31/10/2022
	 */
	@Override
	public List<Product> getAllProducts() {

		log.info("Retrived All Products from Database");
		return productRepository.findAll();
	}

	/**
	 * @Description : To add Product into database
	 * @Returns : It returns Product which has been added
	 * @Params : It takes Product as parameter
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 31/10/2022
	 */
	@Override
	public Product addProduct(Product product) {

		log.info("Adding product to database");

		double price = product.getPrice();

		if (price <= 0) {

			log.error("Price cannot be lessthan or equal to zero");
			throw new InvalidPriceException(
					"Invalid Price : " + price + " (Price cannot be lessthan or equal to zero)");
		}

		log.info("Saved Product to Database");
		return productRepository.save(product);
	}

	/**
	 * @Description : To get Product by using it's id
	 * @Returns : It returns Product
	 * @Params : It takes Product ID as parameter
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 31/10/2022
	 */
	@Override
	public Product getProductById(long id) {

		log.info("Getting product with ID " + id);
		Optional<Product> optionalProduct = productRepository.findById(id);

		if (optionalProduct.isEmpty()) {

			log.error("Product not found with ID " + id);
			throw new IdNotFoundException("Product with ID : " + id + " not found for get");
		}

		log.info("Retrieved product from database with ID " + optionalProduct.get().getId());
		return optionalProduct.get();
	}

	/**
	 * @Description : To update Product by using it's id
	 * @Returns : It returns Updated Product
	 * @Params : It takes Product ID and Product as parameters
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 31/10/2022
	 */
	@Override
	public Product updateProductById(long id, Product product) {

		log.info("Getting product with ID " + id + " to update");
		Optional<Product> optionalProduct = productRepository.findById(id);

		if (optionalProduct.isEmpty()) {
			log.error("Product not found with ID " + id);
			throw new IdNotFoundException("Product with ID : " + id + " not found for update");
		}

		Product newProduct = optionalProduct.get();
		newProduct.setName(product.getName());
		newProduct.setPrice(product.getPrice());
		newProduct.setCategory(product.getCategory());

		log.info("Updated product with ID " + newProduct.getId());
		return productRepository.save(newProduct);
	}

	/**
	 * @Description : To delete Product by using it's id
	 * @Params : It takes Product ID as parameter
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 31/10/2022
	 */
	@Override
	public void deleteProductById(long id) {

		log.info("Getting product with ID " + id + " to delete");

		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isEmpty()) {
			throw new IdNotFoundException("Product with ID : " + id + " not found for delete");
		}
		Product product = optionalProduct.get();

		log.info("Deleted product with ID " + optionalProduct.get());
		productRepository.delete(product);

	}

}
