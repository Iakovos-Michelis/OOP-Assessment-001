package oop_assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Read user input

        ArrayList<Product> productList = new ArrayList<>();

        // Prepopulate with some products
        productList.add(new Electronics("Iphone", 1500.0, "Apple", 24));
        productList.add(new Grocery("Milk", 2.5, 1.5, "21/06/25"));
        productList.add(new Clothing("T-Shirt", 40.0, "M", "Cotton", "Black"));

        boolean running = true;

        // Main menu loop
        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Modify Product");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt(); // Read user choice
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("You chose: Add Product");
                    addProduct(scanner, productList);
                    break;
                case 2:
                    System.out.println("You chose: Search Product");
                    searchProduct(scanner, productList);
                    break;
                case 3:
                    System.out.println("You chose: Modify Product");
                    modifyProduct(scanner, productList);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Add a new product to the list
    public static void addProduct(Scanner scanner, ArrayList<Product> productList) {
        System.out.println("Select product category: ");
        System.out.println("1. Electronics");
        System.out.println("2. Grocery");
        System.out.println("3. Clothing");
        System.out.print("Choice: ");

        int categoryChoice = scanner.nextInt(); // Read the category choice
        scanner.nextLine();

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Product NewProduct = null;
        // Create the new product based on the category choice
        switch (categoryChoice) {
            case 1:
                System.out.print("Enter the brand of the electronic product: ");
                String brand = scanner.nextLine();
                System.out.print("Enter the warranty (in months): ");
                int warranty = scanner.nextInt();
                NewProduct = new Electronics(name, price, brand, warranty);
                break;
            case 2:
                System.out.print("Enter the quantity (in liters): ");
                double quantity = scanner.nextDouble();
                scanner.nextLine(); // clear the newline
                System.out.print("Enter the expiration date (e.g., 2025-06-01): ");
                String expirationDate = scanner.nextLine();
                NewProduct = new Grocery(name, price, quantity, expirationDate);
                break;
            case 3:
                System.out.print("Enter the size of the clothing (e.g., M, L, XL): ");
                String size = scanner.nextLine();
                System.out.print("Enter the material of the clothing: ");
                String material = scanner.nextLine();
                System.out.print("Enter the color of the clothing: ");
                String color = scanner.nextLine();
                NewProduct = new Clothing(name, price, size, material, color);
                break;
            default:
                System.out.println("Invalid category choice.");
                return; // Exit if the category choice is invalid
        }

        if (NewProduct != null) {
            productList.add(NewProduct); // Adding the new product to the list
            System.out.println("Product added successfully!");
        }
    }
    // Search for a product by name
    public static void searchProduct(Scanner scanner, ArrayList<Product> productList) {
        System.out.print("Enter the product name to search: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Product product : productList) {
            if (product.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + product); // Print product details
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }
    }

    // Modify the price of an existing product
    public static void modifyProduct(Scanner scanner, ArrayList<Product> productList) {
        System.out.print("Enter the product name to modify: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Product product : productList) {
            if (product.name.equalsIgnoreCase(name)) {
                found = true;
                System.out.println("Found product: " + product);
                System.out.print("Enter the new price: ");
                double newPrice = scanner.nextDouble();
                scanner.nextLine();
                product.price = newPrice; // Updating product price
                System.out.println("oop_assignment1.Product price updated.");
                break;
            }
        }
        if (!found) {
            System.out.println("oop_assignment1.Product not found.");
        }
    }
}
