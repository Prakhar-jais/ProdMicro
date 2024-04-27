package com.ecomm.productservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ecomm.productservice.model.ProductRequest;
import com.ecomm.productservice.model.ProductResponse;
import com.ecomm.productservice.service.ProductSevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/product")

public class ProductController {


    @Autowired
    private ProductSevice productService;


    @PostMapping("/")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){

        long productId  = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId,HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId  ){

        ProductResponse productResponse = productService.getProductById(productId);

        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }


   


    
}
