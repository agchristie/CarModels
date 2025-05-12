import java.util.List;
import java.util.Scanner;

public class CarDatabaseTester {

    public static void main(String[] args) {
        String filename = "car_data.txt";

        CarDatabase myCarDatabase = new CarDatabase();
        myCarDatabase.loadFile(filename);
        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to the car database!");
        //loops so it doesn't end after just one choice
        while (true) {
            System.out.println("\nPlease pick from the options below.");
            System.out.println("1. Search by Make");
            System.out.println("2. Search by Model");
            System.out.println("3. Display All");
            System.out.println("4. Exit\n");
            System.out.print("Enter your choice: ");

            String choice = input.nextLine();
            if (choice.equals("1")) {
                //search using scanner to get user input
                System.out.print("Enter make name: ");
                String searchTerm = input.nextLine();

                List<Car> searchResults = myCarDatabase.findByMake(searchTerm);

                //print results based on user input
                System.out.println("\nResults for '" + searchTerm + "'\n");
                if (searchTerm.isEmpty()) {
                    System.out.println("You must enter a search term!");
                }
                else if (searchResults.isEmpty()) {
                    System.out.println("No cars found matching '" + searchTerm + "'.");
                }
                else {
                    System.out.println("Found " + searchResults.size() + " matching car(s):");
                    for (Car car : searchResults) {
                        System.out.println(car);
                    }
                    System.out.println();
                }
            }
            //same as searching by make
            else if (choice.equals("2")) {
                System.out.print("Enter model name: ");
                String searchTerm = input.nextLine();

                List<Car> searchResults = myCarDatabase.findByModel(searchTerm);

                //print results
                System.out.println("\nResults for '" + searchTerm + "'\n");
                if (searchTerm.isEmpty()) {
                    System.out.println("You must enter a search term!");
                }
                else if (searchResults.isEmpty()) {
                    System.out.println("No cars found matching '" + searchTerm + "'.");
                }
                else {
                    System.out.println("Found " + searchResults.size() + " matching car(s):");
                    for (Car car : searchResults) {
                        System.out.println(car);
                    }
                }
                System.out.println();
            }
            else if (choice.equals("3")) {
                myCarDatabase.showAllCars();
            }
            else if (choice.equals("4")) {
                System.out.println("\nThank you for accessing the car database!");
                break;

            }
            //if the user inputs something other than one of the choices
            else {
                System.out.println("That is an invalid choice!");
            }

        }
        input.close();
    }
}