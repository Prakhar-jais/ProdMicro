package com.ecomm.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.productservice.entity.Product;
import com.ecomm.productservice.exception.ProductServiceCustomException;
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

        Product product = productRepository.findById(productId).orElseThrow(()-> new ProductServiceCustomException("Product with given id not found","PRODUCT_NOT_FOUND"));

        ProductResponse productResponse = ProductResponse
        .builder()
        .productId(product.getProductid())
        .productName(product.getProductName())
        .price(product.getPrice())
        .quantity(product.getQuantity())
        .build() ;
        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        // TODO Auto-generated method stub
        log.info("Reduce Quantity {} for Id : {}",quantity,productId);

        Product product = productRepository.findById(productId).orElseThrow(()->new ProductServiceCustomException("Product With Given Id No Found", "PRODUCT_NOT_FOUND") );
        
        if(product.getQuantity()<quantity){
            throw new ProductServiceCustomException("Product does not have sufficient Quantity", "INSUFFICIENT_QUANTITY");
        }

        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
        log.info("Product Quantity Updated Successfully");
    }
    
    
}
