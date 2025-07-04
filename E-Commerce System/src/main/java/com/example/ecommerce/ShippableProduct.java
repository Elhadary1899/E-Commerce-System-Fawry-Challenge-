package com.example.ecommerce;
import java.time.LocalDate;

public class ShippableProduct extends Product implements Shippable{
    private double weight;

    ShippableProduct(){}
    ShippableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate){
        super(name, price, quantity, expiryDate);
        this.setWeight(weight);
    }

    public void setWeight(double weight){
        if(weight <= 0){
            System.out.println("Please enter a valid weight!");
        }else {
            this.weight = weight;
        }
    }
    @Override
    public double getWeight() {return this.weight;}
}
