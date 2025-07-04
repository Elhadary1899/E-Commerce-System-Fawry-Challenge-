package com.example.ecommerce;
import javafx.util.Pair;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Pair<Product, Integer>> products = new ArrayList<>();

    public void addToCart(Product product, int quantity) throws Exception {
        if (quantity <= 0) throw new Exception("Quantity must be positive");

        if (product.hasExpired()) {
            System.out.println("We are sorry, " + product.getName() + " is expired!");
            return;
        }

        if(quantity > product.getQuantity()){
            System.out.println("There's no sufficient" + product.getName() + " quantity in our stock!");
            return;
        }

        for (Pair<Product,Integer> item : products) {
            if (item.getKey() == product) {
                item = new Pair<>(product, item.getValue() + quantity);
                product.decrementQuantity(quantity);
                System.out.println(product.getName() + " was added to cart successfully!");
                return;
            }
        }

        products.add(new Pair<>(product, quantity));
        product.decrementQuantity(quantity);
        System.out.println(product.getName() + " was added to cart successfully!");
    }

    public ArrayList<Pair<Product, Integer>> getProducts(){
        return this.products;
    }

    public void showCart(){
        if(products.isEmpty()){
            System.out.println("Your cart is empty!");
            return;
        }
        System.out.println("== Name ====== Price ====== Quantity ==");
        for(Pair<Product, Integer> item : products){
            System.out.println("- " + item.getKey().getName() + " " + item.getKey().getPrice() + " " + item.getValue());
        }
    }
    public void clearCart(){
        for (Pair<Product, Integer> item : products){
            item.getKey().setQuantity(item.getKey().getQuantity() + item.getValue());
        }
        this.products.clear();
    }
}
