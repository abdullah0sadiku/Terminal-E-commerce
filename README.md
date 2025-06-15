# Simple E-commerce Shopping Cart System

This is a **console-based Java application** that simulates a basic online shopping cart experience. Users can interact with the system through a command-line interface to browse products, add items to their cart, remove items, view their cart's contents, and proceed to checkout.

---

## Features

This system provides the following functionalities:

* **Product Catalog:** Displays a list of predefined products available for purchase.
* **Add Products to Cart:** Allows users to add available products to their shopping cart by specifying a product ID.
* **Remove Products from Cart:** Users can remove a single instance of a product from their cart using its ID.
* **View Shopping Cart:** Shows a detailed list of all items currently in the cart, including quantities for duplicate items and a subtotal.
* **Calculate Cart Total:** Computes and displays the cumulative price of all items in the cart.
* **Checkout Process:** Simulates a purchase by displaying the final total and clearing the cart.
* **Interactive Menu:** A user-friendly console menu facilitates navigation and interaction with the system.

---

## Technologies Used

* **Java:** The primary programming language used for developing the application logic.

---

## Concepts Demonstrated

This project effectively utilizes and demonstrates the following core Java programming concepts:

* **Classes and Objects:**
    * `Product` class: Represents individual items with attributes like ID, name, and price.
    * `ShoppingCart` class: Manages the collection of `Product` objects in the cart.
* **Constructors:** Used for initializing `Product` and `ShoppingCart` objects.
* **Methods:** Encapsulated logic and behavior within classes (e.g., `addProduct()`, `removeProductById()`, `calculateTotal()`).
* **Lists (`ArrayList`):** Used to store collections of `Product` objects (both for available inventory and cart items).
* **Maps (`HashMap`):** Utilized in the `ShoppingCart` to efficiently count and display quantities of duplicate products when viewing the cart.
* **Loops (`for`, `do-while`):** Essential for iterating through product lists, managing the main menu, and performing calculations.
* **Conditional Statements (`if-else if`, `switch`):** Used for decision-making (e.g., handling menu choices, product lookup, error handling).
* **Basic Math Operations:** Applied for calculating product subtotals and the overall cart total.
* **User Input (`java.util.Scanner`):** For accepting user commands and data through the console.
* **Exception Handling (`try-catch`):** Implemented in the `Main` class to gracefully manage invalid user input.

---

## How to Run

To compile and execute this application on your local machine, follow these instructions:

1.  **Clone the Repository:**
    If you haven't already, clone this GitHub repository to your local machine:
    ```bash
    git clone [https://github.com/abdullah0sadiku/Terminal-E-commerce](https://github.com/abdullah0sadiku/Terminal-E-commerce)
    ```
    (Ensure you replace `abdullah0sadiku/Shkolla.git` with the actual path to your repository if it's different.)

2.  **Navigate to the Project Directory:**
    Change your current directory to where your Java source files (`Product.java`, `ShoppingCart.java`, `Main.java`) are located. This is typically the root of the cloned repository or a `src` subdirectory within it.
    ```bash
    cd Terminal-E-commerce
    # or if your .java files are in a src folder:
    # cd Terminal-E-commerce/src
    ```

3.  **Compile the Java Files:**
    Open your terminal or command prompt in the directory containing your `.java` files. Compile all the source files:
    ```bash
    javac Product.java ShoppingCart.java Main.java
    ```
    *Note: If you are using an Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse, compilation is usually handled automatically when you build or run your project.*

4.  **Run the Application:**
    Execute the compiled `Main` class to start the application:
    ```bash
    java Main
    ```

---

## Usage Example

Once the application is running, you will be greeted with a welcome message and an interactive menu in your console:

---- Welcome to Terminal E-commerce! ----

View Available Products
Add Product to Cart
Remove Product from Cart
View Shopping Cart
Calculate Cart Total
Checkout
Exit
Enter your choice:


Enter the number corresponding to your desired action and follow the prompts. For example:

* Enter `1` to see the list of items available in the store.
* Enter `2`, then provide a Product ID (e.g., `P001`) to add a Laptop to your cart.
* Enter `4` to view the current contents of your shopping cart.
* Enter `6` to proceed with the checkout process and finalize your purchase.

Have fun exploring from Dulla <3 