package com.amazon.pms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.pms.entity.Product;
import com.amazon.pms.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> findAllProducts() {
		return productService.findAllProducts();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findProductById(@PathVariable int id) {
		return productService.findProductById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable int id) {
		return productService.deleteProductById(id);
	}
	
}
