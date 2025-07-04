package com.example.ecommerce;
import javafx.util.Pair;
import java.util.ArrayList;

public class ShippingService {
    public static void ship(ArrayList<Pair<Product, Integer>> items) {

        double totalWeight = 0;
        for(Pair<Product, Integer> item : items){
            if (item.getKey() instanceof ShippableProduct shippable) {
                System.out.println(item.getValue() + " x " + item.getKey().getName() + " " + (item.getValue() * shippable.getWeight()) + "g");
                totalWeight += (item.getValue() * shippable.getWeight());
            }
        }
        if(totalWeight != 0) {
            System.out.println("          ==Shipment notice==          ");
            System.out.println("=======================================");
            System.out.println("Total package weight is " + totalWeight / 1000 + "kg\n");
            System.out.println("=======================================\n");
        }
    }
}
