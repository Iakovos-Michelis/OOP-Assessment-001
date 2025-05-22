package homework1;

import java.util.Scanner;

public class CarRental {

    private Car[] Garage;

    // Setup with sample vehicles
    public CarRental() {
        Garage = new Car[5];
        Garage[0] = new Car("01", "BMW X5", 105000);
        Garage[1] = new Car("02", "TESLA MODEL S", 90000);
        Garage[2] = new Car("03", "MERCEDES-BENZ C63 AMG", 25000);
        Garage[3] = new Car("04", "TOYOTA YARIS", 120000);
        Garage[4] = new Car("05", "SUZUKI ALTO", 60000);
    }

    // Let someone rent a vehicle by ID
    public void startRenting(String id) {
        for (Car v : Garage) {
            if (v.getID().equals(id)) {
                if (!v.isAvailable()) {
                    System.out.println("Vehicle " + id + " is already taken.");
                } else {
                    v.takeOut();
                    System.out.println("Vehicle " + id + " has been rented out.");
                }
                return;
            }
        }
        System.out.println("Vehicle with ID " + id + " not found.");
    }

    // Return vehicle and update distance
    public void finishRenting(String id, int newDistance) {
        for (Car v : Garage) {
            if (v.getID().equals(id)) {
                if (v.isAvailable()) {
                    System.out.println("Car " + id + " was never rented.");
                } else {
                    v.bringBack(newDistance);
                    System.out.println("Car " + id + " is back. New distance: " + newDistance + " km");
                }
                return;
            }
        }
        System.out.println("Car with ID " + id + " not found.");
    }

    // Showing all cars and their status
    public void showAllCars() {
        System.out.println("\nGarage Status:");
        for (Car v : Garage) {
            System.out.println(v);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CarRental manager = new CarRental();

        while (true) {
            System.out.println("==== Vehicle Rental Menu ====");
            System.out.println("1. Rent a vehicle");
            System.out.println("2. Return a vehicle");
            System.out.println("3. View all vehicles");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle ID to rent: ");
                    String rentID = input.nextLine();
                    manager.startRenting(rentID);
                    break;

                case 2:
                    System.out.print("Enter vehicle ID to return: ");
                    String returnID = input.nextLine();
                    System.out.print("Enter updated distance(km): ");
                    int newDistance = input.nextInt();
                    manager.finishRenting(returnID, newDistance);
                    break;

                case 3:
                    manager.showAllCars();
                    break;

                case 0:
                    System.out.println("Shutting down...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
