package com.example.ecommerce;
import java.time.LocalDate;
import java.util.ArrayList;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private LocalDate expiryDate;
    private static ArrayList<Product> products = new ArrayList<>();

    Product(){}
    Product(String name, double price, int quantity, LocalDate expiryDate){
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setExpiryDate(expiryDate);
        products.add(this);
    }

    public void setName(String name){
        if(!name.isEmpty()){
            this.name = name;
        }else{
            System.out.println("Invalid product name! Please enter a valid name.");
        }
    }
    public String getName(){
        return this.name;
    }

    public void setPrice(double price){
        if(price > 0){
            this.price = price;
        }else {
            System.out.println("Invalid product price! Please enter a valid price.");
        }
    }
    public double getPrice(){
        return this.price;
    }

    public void setQuantity(int quantity){
        if(quantity >= 0){
            this.quantity = quantity;
        }else {
            System.out.println("Invalid product quantity! Please enter a valid quantity.");
        }
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void decrementQuantity(int qty){
        if(qty <= 0 || qty > this.quantity){
            System.out.println("Please enter a valid quantity!");
        }else{
            this.quantity -= qty;
        }
    }

    public void setExpiryDate(LocalDate expiryDate){
        if(expiryDate == null) return;
        if(expiryDate.isBefore(LocalDate.now())){
            System.out.println("This product has already expired, Can't be added to the system!");
        } else {
            this.expiryDate = expiryDate;
        }
    }
    public LocalDate getExpiryDate(){
        return this.expiryDate;
    }
    public boolean hasExpired(){
        if(this.expiryDate == null || this.expiryDate.isAfter(LocalDate.now()))
            return false;
        else
            return true;
    }

    public static void showAllProducts(){
        System.out.println("== Name ====== Price ====== Quantity ==");
        for(Product item: products){
            System.out.println("- " + item.getName() + " " + item.getPrice() + " " + item.getQuantity());
        }
    }
}
