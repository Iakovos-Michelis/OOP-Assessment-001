package oop_assignment1;

public class Electronics extends Product {

    String BrandName;
    int WarrantyPeriod;

    public Electronics(String name, double price, String BrandName, int WarrantyPeriod) {
        super(name, price);
        this.BrandName = BrandName;
        this.WarrantyPeriod = WarrantyPeriod;
    }


    public String toString() {
        return super.toString() + ", Brand: " + BrandName + ", Warranty: " + WarrantyPeriod + " months";
    }
}
