import java.util.Scanner;    // Required for reading user input from the console
import java.util.ArrayList;  // Required for using ArrayList to store products
import java.util.List;       // Required for using the List interface

public class Main {
    public static void main(String[] args) {
        // --- 1. Setup Initial Inventory (Available Products) ---
        // Create a list to hold the products available in our simulated store.
        List<Product> availableProducts = new ArrayList<>();
        availableProducts.add(new Product("P001", "Laptop", 1200.00));
        availableProducts.add(new Product("P002", "Mechanical Keyboard", 150.00));
        availableProducts.add(new Product("P003", "Gaming Mouse", 75.50));
        availableProducts.add(new Product("P004", "External Monitor", 300.00));
        availableProducts.add(new Product("P005", "Webcam", 50.00));

        // --- 2. Initialize Shopping Cart and Scanner ---
        // Create an instance of our ShoppingCart class.
        ShoppingCart myCart = new ShoppingCart();
        // Create a Scanner object to read input from the console.
        Scanner scanner = new Scanner(System.in);

        int choice; // Variable to store the user's menu choice

        System.out.println("---- Welcome to Terminal E-commerce! ----");

        // --- 3. Main Menu Loop ---
        // Use a do-while loop to ensure the menu is displayed at least once.
        do {
            // Display the menu options to the user.
            displayMenu();

            System.out.print("Enter your choice: ");
            // Use a try-catch block to handle potential input errors (e.g., if the user types text instead of a number).
            try {
                choice = scanner.nextInt(); // Read the integer choice from the user
                scanner.nextLine(); // Consume the leftover newline character after reading the integer

                // Use a switch statement to perform actions based on the user's choice.
                switch (choice) {
                    case 1:
                        // Option 1: View Available Products
                        System.out.println("\n--- Available Products ---");
                        if (availableProducts.isEmpty()) {
                            System.out.println("No products currently available.");
                        } else {
                            for (Product p : availableProducts) {
                                System.out.println(p.getProductInfo());
                                System.out.println("--------------------------"); // Separator for readability
                            }
                        }
                        break;
                    case 2:
                        // Option 2: Add Product to Cart
                        System.out.print("Enter Product ID to add to cart: ");
                        String addProductId = scanner.nextLine();
                        // Find the product in the available inventory
                        Product productToAdd = findProductById(availableProducts, addProductId);
                        if (productToAdd != null) {
                            myCart.addProduct(productToAdd); // Add a copy of the product to the cart
                        } else {
                            System.out.println("Product with ID '" + addProductId + "' not found in inventory.");
                        }
                        break;
                    case 3:
                        // Option 3: Remove Product from Cart
                        System.out.print("Enter Product ID to remove from cart: ");
                        String removeProductId = scanner.nextLine();
                        myCart.removeProductById(removeProductId); // Call the remove method on the cart
                        break;
                    case 4:
                        // Option 4: View Shopping Cart
                        myCart.viewCart(); // Display the contents of the cart
                        break;
                    case 5:
                        // Option 5: Calculate Cart Total
                        double currentCartTotal = myCart.calculateTotal(); // Get the total from the cart
                        System.out.println("\nYour current cart total is: $" + String.format("%.2f", currentCartTotal));
                        break;
                    case 6:
                        // Option 6: Checkout
                        myCart.checkout(); // Simulate the checkout process
                        break;
                    case 7:
                        // Option 7: Exit
                        System.out.println("Thank you for shopping with us! Goodbye.");
                        break;
                    default:
                        // Handle invalid menu choices
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (java.util.InputMismatchException e) {
                // Catch non-integer input errors
                System.out.println("Invalid input. Please enter a number for your choice.");
                scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
                choice = 0; // Set choice to an invalid number to continue the loop
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine(); // Wait for user to press Enter before displaying menu again
        } while (choice != 7); // Loop continues until the user chooses to exit (choice 7)

        // --- 4. Close Resources ---
        scanner.close(); // Close the scanner to release system resources
    }

    // --- Helper Method: displayMenu ---
    // This method is static because it's called from the static main method
    // and doesn't need an instance of Main.
    public static void displayMenu() {
        System.out.println("\n------------------------------------");
        System.out.println("1. View Available Products");
        System.out.println("2. Add Product to Cart");
        System.out.println("3. Remove Product from Cart");
        System.out.println("4. View Shopping Cart");
        System.out.println("5. Calculate Cart Total");
        System.out.println("6. Checkout");
        System.out.println("7. Exit");
        System.out.println("------------------------------------");
    }

    // --- Helper Method: findProductById ---
    // This static method helps find a product in a given list of products by its ID.
    // It's useful for finding items in the 'availableProducts' list.
    public static Product findProductById(List<Product> products, String productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                return p; // Return the found product
            }
        }
        return null; // Return null if no product with the given ID is found
    }
}
