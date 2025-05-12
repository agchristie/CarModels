import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarDatabase {
    private List<Car> cars;

    public CarDatabase() {
        this.cars = new ArrayList<>();
    }

    //loads designated file of cars using try/catch for errors
    public void loadFile(String filename) {
        System.out.println("Loading data...");
        try (Scanner file = new Scanner(new File(filename))) {
            int carsLoaded = 0;
            //get car make and model by using scanner on each line of the file
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] parts = line.split(",");
                String make = parts[0].trim();
                String model = parts[1].trim();
                Car car = new Car(make, model);
                this.cars.add(car);
                carsLoaded++;
            }
            System.out.println("Loaded " + carsLoaded + " cars.");

        }
        //error messages
        catch (FileNotFoundException e) {
            System.err.println("Error: File not found at " + filename);
        }
        catch (Exception e) {
            System.err.println("Error occurred while reading file: " + e.getMessage());
        }
    }

    public List<Car> findByMake(String searchTerm) {
        List<Car> results = new ArrayList<>();
        //if user inputs nothing
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return results;
        }

        //convert to lowercase for easier matching
        String lowercaseTerm = searchTerm.trim().toLowerCase();

        //adds relevant cars to the search results
        for (Car car : this.cars) {
            if (car.getMake().toLowerCase().contains(lowercaseTerm)) {
                results.add(car);
            }
        }
        return results;
    }

    //same as findByMake but using model instead
    public List<Car> findByModel(String searchTerm) {
        List<Car> results = new ArrayList<>();
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return results;
        }
        String lowercaseTerm = searchTerm.trim().toLowerCase();

        for (Car car : this.cars) {
            if (car.getModel().toLowerCase().contains(lowercaseTerm)) {
                results.add(car);
            }
        }
        return results;
    }

    //uses toString to print the cars
    public void showAllCars() {
        System.out.println("\nAll Cars by Make and Model:");
        for (Car car : this.cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}