package com.ecomm.productservice.service;

import com.ecomm.productservice.model.ProductRequest;
import com.ecomm.productservice.model.ProductResponse;

public interface ProductSevice {

    public long addProduct(ProductRequest productRequest) ;

    public ProductResponse getProductById(long productId);

    public void reduceQuantity(long productId, long quantity);

    
    
}
