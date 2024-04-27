package com.ecomm.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.productservice.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
