package oop_assignment1;

public class Grocery extends Product {

    double weight;
    String ΕxpirationDate;

    public Grocery(String name, double price, double weight, String ExpirationDate) {
        super(name, price);
        this.weight = weight;
        this.ΕxpirationDate = ExpirationDate;
    }

    public String toString() {
        return super.toString() + ", Quantity: " + weight + " lt, Expiration Date: " + ΕxpirationDate;
    }

}
