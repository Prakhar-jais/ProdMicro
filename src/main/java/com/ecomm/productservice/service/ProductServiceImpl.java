package com.ecomm.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.productservice.entity.Product;
import com.ecomm.productservice.model.ProductRequest;
import com.ecomm.productservice.model.ProductResponse;
import com.ecomm.productservice.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductSevice{


    @Autowired
    private ProductRepository productRepository ;

    @Override
    public long addProduct(ProductRequest productRequest) {
        

        log.info("Adding Product ....");

        Product product = Product.builder()
        .productName(productRequest.getName())
        .price(productRequest.getPrice())
        .quantity(productRequest.getQuantity())
        .build();

        productRepository.save(product);

        log.info("Product Created");
        return product.getProductid();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        
        log.info("Get the product related to that product Id : {}",productId);

        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product with given id not found"));

        ProductResponse productResponse = ProductResponse
        .builder()
        .productId(product.getProductid())
        .productName(product.getProductName())
        .price(product.getPrice())
        .quantity(product.getQuantity())
        .build() ;
        return productResponse;
    }
    
    
}
