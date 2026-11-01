package p2;


import java.io.*;
import java.util.ArrayList;

public class CarFileManager 
{
    private static final String FILE_NAME = "cars.txt";

    // Save car records to a file
    public static void saveCars(ArrayList<Car> cars) {
        try (BufferedWriter bw =
                 new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Car car : cars) {
                bw.write(car.toFileString());
                bw.newLine();
            }

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving data: "
                    + e.getMessage());
        }
    }

    // Read car records from a file
    public static ArrayList<Car> loadCars() {
        ArrayList<Car> cars = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return cars;
        }

        try (BufferedReader br =
                 new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 5) {
                    try {
                        Car car = new Car(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            Double.parseDouble(data[3]),
                            Boolean.parseBoolean(data[4])
                        );

                        cars.add(car);

                    } catch (NumberFormatException e) {
                        System.out.println(
                            "Invalid record skipped.");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading data: "
                    + e.getMessage());
        }

        return cars;
    }
}
