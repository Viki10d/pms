package com.amazon.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.pms.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
