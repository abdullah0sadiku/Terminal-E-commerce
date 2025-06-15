public class Product {
    // Attributes
    private String productId;
    private String name;
    private double price;

    // Constructor to initialize the product
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Method to get product information as a formatted String
    // Changed return type from void to String
    public String getProductInfo() {
        // Corrected String concatenation and syntax for return
        return "Product ID: " + productId + "\nName: " + name + "\nPrice: $" + String.format("%.2f", price);
        // Using String.format("%.2f", price) ensures price is formatted to two decimal places.
    }

    // Getter methods: changed return types from void to String/double
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}