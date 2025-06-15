import java.util.List;      // Imports the List interface from Java's utility library
import java.util.ArrayList;  // Imports the ArrayList class, a common List implementation
import java.util.HashMap;    // Imports HashMap for efficient key-value storage (used for counting products)
import java.util.Map;      // Imports the Map interface, which HashMap implements

public class ShoppingCart {
    // -------------------------------------------------------------
    // 1. Attribute (Instance Variable / Field)
    // -------------------------------------------------------------
    private List<Product> items; // Declares a private list to hold Product objects

    // -------------------------------------------------------------
    // 2. Constructor
    // -------------------------------------------------------------
    // This constructor initializes a new ShoppingCart object.
    public ShoppingCart() {
        // 'this.items' refers to the 'items' attribute of the current ShoppingCart object.
        // It's initialized as a new, empty ArrayList, ready to store products.
        this.items = new ArrayList<>();
    }

    // -------------------------------------------------------------
    // 3. Methods
    // -------------------------------------------------------------

    // Method to add a Product object to the shopping cart.
    // It takes a 'Product' object as a parameter.
    public void addProduct(Product product) {
        // The 'add()' method of ArrayList appends the given product to the end of the list.
        items.add(product);
        // Prints a confirmation message to the console.
        System.out.println("'" + product.getName() + "' added to cart.");
    }

    // Method to remove one instance of a product from the cart by its product ID.
    // It returns 'true' if a product was successfully removed, 'false' otherwise.
    public boolean removeProductById(String productId) {
        // Iterates through the 'items' list using a traditional for loop with an index.
        // This approach is safer when you might remove elements during iteration
        // compared to an enhanced for-loop, which can cause 'ConcurrentModificationException'.
        for (int i = 0; i < items.size(); i++) {
            Product productInCart = items.get(i); // Gets the product object at the current index.
            // Compares the 'productId' of the product in the cart with the 'productId'
            // provided as a parameter.
            // IMPORTANT: For String comparison, always use '.equals()' method, not '=='.
            // '==' checks if two references point to the exact same object in memory,
            // while '.equals()' checks if the content (characters) of the strings are the same.
            if (productInCart.getProductId().equals(productId)) {
                items.remove(i); // Removes the product object at the current index from the list.
                System.out.println("Product with ID '" + productId + "' removed from cart.");
                return true; // Exits the method and indicates success.
            }
        }
        // If the loop completes without finding and removing a product, this message is printed.
        System.out.println("Product with ID '" + productId + "' not found in cart.");
        return false; // Exits the method and indicates failure.
    }

    // Method to display all items currently in the shopping cart.
    // It has a 'void' return type because its primary purpose is to print information to the console.
    public void viewCart() {
        // Checks if the 'items' list is empty.
        if (items.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
            return; // If empty, prints a message and exits the method.
        }

        System.out.println("\n--- Your Shopping Cart ---");

        // Uses a HashMap to count how many times each unique product ID appears in the cart.
        // Key: Product ID (String), Value: Count of that product (Integer).
        Map<String, Integer> productCounts = new HashMap<>();
        // Uses another HashMap to store the actual Product object for each unique ID.
        // This allows retrieving product details (name, price) when displaying.
        Map<String, Product> productDetails = new HashMap<>();

        // First loop: Populates the productCounts and productDetails maps.
        for (Product item : items) {
            String id = item.getProductId(); // Gets the ID of the current product.
            // Increments the count for this product ID. If the ID is not yet in the map,
            // 'getOrDefault(id, 0)' returns 0, so it starts counting from 1.
            productCounts.put(id, productCounts.getOrDefault(id, 0) + 1);
            productDetails.put(id, item); // Stores the product object itself, mapped to its ID.
        }

        double currentTotal = 0; // Initializes a variable to sum the total price of items displayed.

        // Second loop: Iterates through the entries (key-value pairs) of the productCounts map.
        // This ensures each unique product is displayed once, with its total count.
        for (Map.Entry<String, Integer> entry : productCounts.entrySet()) {
            String productId = entry.getKey();   // Gets the unique product ID (the key).
            int count = entry.getValue();        // Gets the count for that product (the value).
            Product product = productDetails.get(productId); // Retrieves the Product object using its ID.

            // Prints a formatted line for each unique product, including quantity and subtotal.
            System.out.println(
                product.getName() + " (ID: " + product.getProductId() + ") - " +
                "$" + String.format("%.2f", product.getPrice()) + " x " + count +
                " = $" + String.format("%.2f", product.getPrice() * count)
            );
            // Adds the subtotal for this product type to the running currentTotal.
            currentTotal += product.getPrice() * count;
        }
        System.out.println("--------------------------");
        System.out.println("Current Total: $" + String.format("%.2f", currentTotal));
        System.out.println("--------------------------\n");
    }

    // Method to calculate the total price of all items currently in the cart.
    // It returns a 'double' representing the sum of all product prices.
    public double calculateTotal() {
        double total = 0; // Initializes the total sum.
        // Iterates through each Product object in the 'items' list.
        for (Product product : items) {
            total += product.getPrice(); // Adds the price of the current product to the total.
        }
        // Returns the final calculated total after iterating through all items.
        return total;
    }

    // Method to simulate the checkout process.
    // It has a 'void' return type as it performs actions (prints, clears cart).
    public void checkout() {
        // Checks if the cart is empty before proceeding with checkout.
        if (items.isEmpty()) {
            System.out.println("Your cart is empty. Nothing to checkout.");
            return; // Exits the method if the cart is empty.
        }

        double finalTotal = calculateTotal(); // Calls calculateTotal() to get the final sum.
        System.out.println("\n--- Proceeding to Checkout ---");
        System.out.println("Your final total is: $" + String.format("%.2f", finalTotal));
        System.out.println("Thank you for your purchase!");

        items.clear(); // Clears all products from the 'items' list, simulating a completed purchase.
        System.out.println("Your cart has been cleared.");
        System.out.println("------------------------------\n");
    }
}