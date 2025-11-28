package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.entity.Product;
import com.jbk.repositiory.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// add product
	public boolean addProduct(Product product) {
		Product adddedProduct = productRepository.save(product);
		if (adddedProduct != null) {
			return true;
		}
		return false;
	}

	// get product by id

	public Product getProductById(long id) {
		Product product = productRepository.findById(id).orElse(null);
		return product;
	}

	// get all products

	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	// update product

	public boolean updateProduct(Product product) {
        boolean isExists = productRepository.existsById(product.getProductId());
        if (isExists) {
            productRepository.save(product);
            return true;
        }
	return false;
}

}
