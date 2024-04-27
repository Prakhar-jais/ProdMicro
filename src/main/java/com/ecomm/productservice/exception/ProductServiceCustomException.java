package com.ecomm.productservice.exception;

public class ProductServiceCustomException extends RuntimeException  {
    
    private String errorCode ;


    public ProductServiceCustomException(String message,String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
