package p2;



import java.util.ArrayList;
import java.util.Scanner;

public class CarShowroomManagement {
    static Scanner sc = new Scanner(System.in);

    static void addCar() {
        ArrayList<Car> cars = CarFileManager.loadCars();

        System.out.print("Enter Car ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Car c : cars) {
            if (c.id == id) {
                System.out.println("Car ID already exists.");
                return;
            }
        }

        System.out.print("Enter Brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(sc.nextLine());

        cars.add(new Car(id, brand, model, price, true));
        CarFileManager.saveCars(cars);

        System.out.println("Car added successfully!");
    }

    static void displayCars() {
        ArrayList<Car> cars = CarFileManager.loadCars();

        if (cars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }

        for (Car c : cars) {
            c.display();
        }
    }

    static void searchCar() {
        ArrayList<Car> cars = CarFileManager.loadCars();

        System.out.print("Enter Car ID to search: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Car c : cars) {
            if (c.id == id) {
                c.display();
                return;
            }
        }

        System.out.println("Car not found.");
    }

    static void sellCar() {
        ArrayList<Car> cars = CarFileManager.loadCars();

        System.out.print("Enter Car ID to sell: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Car c : cars) {
            if (c.id == id) {
                if (!c.available) {
                    System.out.println("Car is already sold.");
                    return;
                }

                c.available = false;
                CarFileManager.saveCars(cars);
                System.out.println("Car sold successfully!");
                return;
            }
        }

        System.out.println("Car not found.");
    }

    static void deleteCar() {
        ArrayList<Car> cars = CarFileManager.loadCars();

        System.out.print("Enter Car ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean removed = cars.removeIf(c -> c.id == id);

        if (removed) {
            CarFileManager.saveCars(cars);
            System.out.println("Car deleted successfully!");
        } else {
            System.out.println("Car not found.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== CAR SHOWROOM MANAGEMENT ===");
            System.out.println("1. Add Car");
            System.out.println("2. Display Cars");
            System.out.println("3. Search Car");
            System.out.println("4. Sell Car");
            System.out.println("5. Delete Car");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    displayCars();
                    break;
                case 3:
                    searchCar();
                    break;
                case 4:
                    sellCar();
                    break;
                case 5:
                    deleteCar();
                    break;
                case 6:
                    System.out.println("Program closed.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
