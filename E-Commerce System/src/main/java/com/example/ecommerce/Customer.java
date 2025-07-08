package com.example.ecommerce;
import javafx.util.Pair;
import java.util.Scanner;

public class Customer {
    private static int customersCounter = 0;
    private final int customerID;
    private String name;
    private double balance;

    Customer(){
        customersCounter++;
        this.customerID = customersCounter;
    }
    Customer(String name, double balance){
        customersCounter++;
        this.customerID = customersCounter;
        this.setName(name);
        this.setBalance(balance);
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public void setName(String name) {
        if(!name.isEmpty()){
            this.name = name;
        }else{
            System.out.println("Invalid name! Please enter a valid name.");
        }
    }
    public String getName() {
        return this.name;
    }

    public void setBalance(double balance) {
        if(balance >= 0){
            this.balance = balance;
        }else {
            System.out.println("Invalid balance amount! Please enter a valid balance amount.");
        }
    }
    public double getBalance() {
        return this.balance;
    }

    public void printDetails(){
        System.out.println("ID: " + this.getCustomerID() + "\nName: " + this.getName() + "\nBalance: " + this.getBalance());
    }

    public void checkout(Customer customer, Cart cart) throws Exception {
        Scanner in = new Scanner(System.in);

        if(cart.getProducts().isEmpty()){
            throw new EmptyCartException("Your cart is Empty!");
        }

        System.out.println("          Welcome to checkout :)          ");
        System.out.println("==========================================");
        System.out.println("Customer ID: " + customer.getCustomerID() + "\nCustomer name: " + customer.getName() + "\nCustomer balance: " + customer.getBalance() + "\n");

        ShippingService.ship(cart.getProducts());

        System.out.println("          ==Checkout receipt==          ");
        System.out.println("========================================");

        double subtotal = 0;
        for(Pair<Product, Integer> item : cart.getProducts()){
            System.out.println(item.getValue() + " x " + item.getKey().getName() + " " + (item.getValue() * item.getKey().getPrice()));
            subtotal += item.getValue() * item.getKey().getPrice();
        }
        double total = subtotal + 30;
        System.out.println("========================================");
        System.out.println("Subtotal: " + subtotal + "\nShipping: 30\nTotal amount: " + total);

        if(total > customer.getBalance()){
            cart.clearCart();
            throw new InsufficientBalanceException("You have insufficient balance, we can't proceed with the checkout!");
        }

        System.out.println("========================================");
        System.out.println("Confirm the order? \n1) Yes\n2) No");
        int choice = in.nextInt();
        if(choice == 1){
            customer.setBalance(customer.getBalance() - total);
            cart.getProducts().clear();
            System.out.println("Order confirmed for " + total + "$ , Your current balance is: " + customer.getBalance());
        }else {
            for (Pair<Product, Integer> item : cart.getProducts()){
                item.getKey().setQuantity(item.getKey().getQuantity() + item.getValue());
            }
            System.out.println("Order Cancelled, your cart is empty now.");
            cart.clearCart();
        }
    }
}
