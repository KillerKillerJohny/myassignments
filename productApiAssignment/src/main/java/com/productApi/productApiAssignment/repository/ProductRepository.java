package com.productApi.productApiAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productApi.productApiAssignment.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
	
}
