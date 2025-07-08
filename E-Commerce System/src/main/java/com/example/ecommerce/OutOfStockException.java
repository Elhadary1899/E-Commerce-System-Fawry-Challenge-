package com.example.ecommerce;

public class OutOfStockException extends Exception{
    OutOfStockException(String message){
        super(message);
    }
}
