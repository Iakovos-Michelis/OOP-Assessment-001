package homework1;

public class Car {

    // Info about the car
    private String id;
    private String name;
    private int distanceDriven;
    private boolean isAvailable;

    // New car with given details
    public Car(String id, String name, int distanceDriven) {
        this.id = id;
        this.name = name;
        this.distanceDriven = distanceDriven;
        this.isAvailable = true; // By default, vehicle is available
    }

    // Getting the ID of the car
    public String getID() {
        return id;
    }

    // Getting the name/model of the car
    public String getName() {
        return name;
    }

    // Getting how many kilometers/miles it has been driven
    public int getDistanceDriven() {
        return distanceDriven;
    }

    // Checking if the car is available for rent
    public boolean isAvailable() {
        return isAvailable;
    }

    // Not available
    public void takeOut() {
        isAvailable = false;
    }

    // Returned and update distance driven
    public void bringBack(int newDistance) {
        isAvailable = true;
        distanceDriven = newDistance;
    }

    // Car info
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Distance: " + distanceDriven +
                " km, Available: " + (isAvailable ? "Yes" : "No");
    }
}
