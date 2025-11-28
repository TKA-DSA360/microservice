package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Product;
import com.jbk.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// add product

	@PostMapping("/add")
	public ResponseEntity<Boolean> addProduct(@RequestBody Product product) {

		boolean isAdded = productService.addProduct(product);
		if (isAdded) {
			return ResponseEntity.ok(true);

        } else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
		
	}

	// get product by id
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		
		Product product = productService.getProductById(id);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// get all products

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProducts = productService.getAllProducts();
		if (allProducts != null && !allProducts.isEmpty()) {
			return ResponseEntity.ok(allProducts);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}

	// update product
	@PutMapping("/update")
	public ResponseEntity<Boolean> updateProduct(@RequestBody Product product) {
		
		boolean isUpdated = productService.updateProduct(product);
		if (isUpdated) {
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
		}
	}

}
