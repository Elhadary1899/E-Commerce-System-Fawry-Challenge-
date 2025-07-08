package com.example.ecommerce;

public class ItemExpiredException extends Exception{
    ItemExpiredException(String message){
        super(message);
    }
}