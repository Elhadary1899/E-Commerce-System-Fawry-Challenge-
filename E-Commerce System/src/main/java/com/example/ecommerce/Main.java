package com.example.ecommerce;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        // Declaring & Initializing the products
        ShippableProduct cheese = new ShippableProduct("Cheese", 100, 5,200, LocalDate.now().plusDays(50));
        ShippableProduct biscuits = new ShippableProduct("Biscuits", 150, 5,700, LocalDate.now());
        ShippableProduct tv = new ShippableProduct("TV", 500, 5,700, null);
        Product mobile = new Product("Mobile", 250, 5, null);
        Product mobileScratchScreen = new Product("Mobile Scratch Screen", 50, 5, null);

        // Declaring & Initializing the customer
        Customer customer = new Customer("Ahmed", 500);
        // Declaring & Initializing the cart
        Cart cart = new Cart();

        // The System Interface
        System.out.println("          Welcome to our Store :)          ");
        System.out.println("===========================================");

        int choice = 0;
        do{
            System.out.println("1)Show your Details \n2) Show our Products \n3) Place an order \n4) Show my Cart \n5) Go to Checkout \n6)Clear Your Cart \n7)Exit");
            choice = in.nextInt();

            switch (choice){
                case 1:
                    customer.printDetails();
                    System.out.println("===========================================\n");
                    break;
                case 2:
                    Product.showAllProducts();
                    System.out.println("===========================================\n");
                    break;
                case 3:
                    System.out.println("Which product do you want to order? \n1)Cheese \n2)Biscuits \n3)TV \n4)Mobile \n5)Mobile Scratch Screen");
                    int order = in.nextInt();
                    System.out.println("Enter the quantity you wish to order: ");
                    int quantity = in.nextInt();
                    switch (order){
                        case 1:
                            cart.addToCart(cheese, quantity);
                            break;
                        case 2:
                            cart.addToCart(biscuits, quantity);
                            break;
                        case 3:
                            cart.addToCart(tv, quantity);
                            break;
                        case 4:
                            cart.addToCart(mobile, quantity);
                            break;
                        case 5:
                            cart.addToCart(mobileScratchScreen, quantity);
                            break;
                        default:
                            System.out.println("Invalid Input!");
                            break;
                    }
                    System.out.println("===========================================\n");
                    break;
                case 4:
                    cart.showCart();
                    System.out.println("===========================================\n");
                    break;
                case 5:
                    customer.checkout(customer, cart);
                    System.out.println("===========================================\n");
                    break;
                case 6:
                    cart.clearCart();
                    System.out.println("Cart cleared successfully!");
                    System.out.println("===========================================\n");
                    break;
                case 7:
                    System.out.println("Thanks for visiting us, we wish to see you again :)");
                    System.exit(0);
                    break;
            }
        } while(choice != 7);

    }
}