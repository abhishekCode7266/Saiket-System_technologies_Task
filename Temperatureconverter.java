import java.util.Scanner;

public class Temperatureconverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== Temperature Converter =====");

        while (running) {
            System.out.println("\n1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (choice == 3) {
                running = false;
                System.out.println("Goodbye!");
                break;
            }

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            System.out.print("Enter the temperature value: ");
            double temp;
            try {
                temp = Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number.");
                continue;
            }

            if (choice == 1) {
                double result = celsiusToFahrenheit(temp);
                System.out.printf("%.2f C = %.2f F%n", temp, result);
            } else {
                double result = fahrenheitToCelsius(temp);
                System.out.printf("%.2f F = %.2f C%n", temp, result);
            }
        }

        sc.close();
    }

    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}