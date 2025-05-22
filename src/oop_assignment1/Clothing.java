package oop_assignment1;

public class Clothing extends Product {

    String size;
    String material;
    String color;

    public Clothing(String name, double price, String size, String material, String color) {
        super(name, price);
        this.size = size;
        this.material = material;
        this.color = color;
    }


    public String toString() {
        return super.toString() + ", Size: " + size + ", Material: " + material + ", Color: " + color;
    }
}
