# 🛒 E-Commerce System – Fawry Quantum Internship Challenge

This project is a simple console-based **E-Commerce System** implemented in Java for the **Fawry Rise Journey Full Stack Development Internship Challenge**. The system simulates real-world product management, cart functionality, and order checkout — while handling constraints like product expiry, stock validation, and shipping logistics.

## 📌 Features

- 🧾 **Product Definition**
  - Each product has a name, price, and quantity.
  - Products may optionally:
    - ❗ Expire (e.g., Cheese, Biscuits)
    - 📦 Require shipping and have a weight (e.g., TV, Cheese)
  
- 🛍️ **Cart Management**
  - Add products to the cart with quantity constraints.
  - Prevent adding expired or out-of-stock items.

- 💳 **Customer Checkout**
  - Checkout prints:
    - Order subtotal
    - Shipping cost
    - Final amount paid
    - Customer balance after purchase
  - Handles errors like:
    - Empty cart
    - Insufficient balance
    - Expired/out-of-stock products
