package p2;


public class Car {
    int id;
    String brand;
    String model;
    double price;
    boolean available;

    public Car(int id, String brand, String model,
               double price, boolean available) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.available = available;
    }

    public void display() {
        System.out.println("Car ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: Rs. " + price);
        System.out.println("Status: "
                + (available ? "Available" : "Sold"));
        System.out.println("----------------------");
    }

    public String toFileString() {
        return id + "|" + brand + "|" + model + "|"
                + price + "|" + available;
    }
}

