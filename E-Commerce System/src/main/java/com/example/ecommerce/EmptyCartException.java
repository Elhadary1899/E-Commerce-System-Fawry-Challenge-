package com.example.ecommerce;

public class EmptyCartException extends Exception{
    EmptyCartException(String message){
        super(message);
    }
}
