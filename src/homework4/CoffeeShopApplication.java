package homework4;

import java.sql.*;
import java.util.Scanner;

public class CoffeeShopApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Database connection info
        String url = "jdbc:mysql://localhost:3306/coffeshop";
        String user = "root";
        String pass = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to database successfully!");

            while (true) {
                showMenu();
                String choice = input.nextLine();

                switch (choice) {
                    case "1":
                        addNewOrder(conn, input);
                        break;
                    case "2":
                        viewOrdersByDate(conn, input);
                        break;
                    case "3":
                        showTotalSpentByCustomer(conn, input);
                        break;
                    case "0":
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    // Showing the main menu options
    private static void showMenu() {
        System.out.println("\nCoffee Shop Order System");
        System.out.println("--------------------------");
        System.out.println("1. Add New Order");
        System.out.println("2. View Orders by Date");
        System.out.println("3. Total Amount by Customer");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    // Adding an order into the database
    private static void addNewOrder(Connection conn, Scanner input) {
        try {
            System.out.print("Enter Order ID: ");
            int id = Integer.parseInt(input.nextLine());

            System.out.print("Enter Customer Name: ");
            String name = input.nextLine();

            System.out.print("Enter Amount Paid: ");
            double amount = Double.parseDouble(input.nextLine());

            System.out.print("Enter Order Date (YYYY-MM-DD): ");
            String date = input.nextLine();

            String sql = "INSERT INTO orders (OrderID, Name, AmountPaid, Date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setDouble(3, amount);
            stmt.setString(4, date);
            stmt.executeUpdate();

            System.out.println("Order added successfully!");

        } catch (Exception e) {
            System.out.println("Error adding order: " + e.getMessage());
        }
    }

    // Showing all orders placed on a specific date
    private static void viewOrdersByDate(Connection conn, Scanner input) {
        try {
            System.out.print("Enter Date (YYYY-MM-DD): ");
            String date = input.nextLine();

            String sql = "SELECT * FROM orders WHERE Date = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, date);
            ResultSet result = stmt.executeQuery();

            System.out.println("\n📅 Orders on " + date + ":");
            while (result.next()) {
                System.out.println("Order ID: " + result.getInt("OrderID") +
                        ", Name: " + result.getString("Name") +
                        ", Amount: $" + result.getDouble("AmountPaid"));
            }

        } catch (SQLException e) {
            System.out.println("⚠️ Error fetching data: " + e.getMessage());
        }
    }

    // Calculating total spent by a customer
    private static void showTotalSpentByCustomer(Connection conn, Scanner input) {
        try {
            System.out.print("Enter Customer Name: ");
            String name = input.nextLine();

            String sql = "SELECT SUM(AmountPaid) AS Total FROM orders WHERE Name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                double total = result.getDouble("Total");
                System.out.println("Total spent by " + name + ": $" + total);
            } else {
                System.out.println("No orders found for customer: " + name);
            }

        } catch (SQLException e) {
            System.out.println("Error calculating total: " + e.getMessage());
        }
    }
}