package oop_assignment1;

public class Product {

    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "Name: " + name + ", Price: " + price;
    }
}

