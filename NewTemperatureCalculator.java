import java.util.Scanner;
import java.util.InputMismatchException;

public class NewTemperatureCalculator {

    static final int FAHRENHEIT_TO_CELSIUS = 1;
    static final int CELSIUS_TO_FAHRENHEIT = 2;
    static final double ROUNDING_FACTOR = 10.0;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
    
        boolean continueCalculating = true;

        while (continueCalculating) {
            showMainMenu();
            int choice = getValidChoice();

            try {
                if (choice == FAHRENHEIT_TO_CELSIUS) {
                    convertFahrenheitToCelsius();
                } else {
                    convertCelsiusToFahrenheit();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scan.nextLine(); // Clear the invalid input
                continue;
            }

            System.out.println("Do you want to calculate again? (yes/no)");
            continueCalculating = wantToContinue();
        }

        System.out.println("Thank you for using the temperature calculator");
        scan.close();
    }

    static void showMainMenu() {
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter your choice (1 or 2): ");
    }

    static int getValidChoice() {
        while (true) {
            if (scan.hasNextInt()) {
            	int choice = scan.nextInt();
                if (choice == FAHRENHEIT_TO_CELSIUS) {
                    return choice;
                } else {
                    if (choice == CELSIUS_TO_FAHRENHEIT) {
                        return choice;
                    }
                }
            } else {
                scan.next(); // Consume invalid input
            }
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    static void convertFahrenheitToCelsius() {
        System.out.print("Enter Fahrenheit value: ");
        double fahrenheit = scan.nextDouble();
        double celsius = fahrenheitToCelsius(fahrenheit);
        System.out.printf("%.1f°F is %.1f°C%n", fahrenheit, celsius);
    }

    static void convertCelsiusToFahrenheit() {
        System.out.print("Enter Celsius value: ");
        double celsius = scan.nextDouble();
        double fahrenheit = celsiusToFahrenheit(celsius);
        System.out.printf("%.1f°C is %.1f°F%n", celsius, fahrenheit);
    }

    static double fahrenheitToCelsius(double fahrenheit) {
        return round((fahrenheit - 32) * 5 / 9);
    }

    static double celsiusToFahrenheit(double celsius) {
        return round((celsius * 9 / 5) + 32);
    }

    static double round(double value) {
        return Math.round(value * ROUNDING_FACTOR) / ROUNDING_FACTOR;
    }

    static boolean wantToContinue() {
        while (true) {
            String input = scan.next().toLowerCase();
            if (input.equals("yes")) return true;
            if (input.equals("no")) return false;
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }
}