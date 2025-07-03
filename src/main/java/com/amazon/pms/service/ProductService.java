package com.amazon.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amazon.pms.Dao.ProductDao;
import com.amazon.pms.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;

	public ResponseEntity<?> saveProduct(Product product) {
		Product savedProduct = productDao.saveProduct(product);
		return ResponseEntity.status(201).body(savedProduct);
	}

	public ResponseEntity<?> findAllProducts() {
		List<Product> products = productDao.findAllProducts();
		return ResponseEntity.ok(products);
	}

	public ResponseEntity<?> findProductById(int id) {
		Optional<Product> productById = productDao.findProductById(id);
		if(productById.isPresent()) {
			return ResponseEntity.status(200).body(productById.get());
		}
		return ResponseEntity.status(400).body("The product with the given Id is not present");
	}

	public ResponseEntity<?> deleteProductById(int id) {
		if(this.findProductById(id).getStatusCode().value() == 200) {
			productDao.deleteProductById(id);
			return ResponseEntity.ok("Successfully Deleted");
		}
		return ResponseEntity.status(400).body("Product with the given Id is not found");
	}
	
}
