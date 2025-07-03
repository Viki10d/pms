package com.amazon.pms.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazon.pms.entity.Product;
import com.amazon.pms.repository.ProductRepository;

@Repository
public class ProductDao {
	
	@Autowired
	ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> findProductById(int id) {
		return productRepository.findById(id);
	}

	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}	
	
}
