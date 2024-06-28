import java.util.Scanner;
import java.util.InputMismatchException;

public class NewTemperatureCalculator {

    static final int faherenheitToCelsius = 1;
    static final int celsiusToFaherenheit = 2;
    static final double roundingFactor = 10.0;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
    	boolean continueCalculating = true;

    	while (continueCalculating) {
    	    showMainMenu();
    	    int choice = getValidChoice();

    	    if (choice == faherenheitToCelsius) {
    	        convertFahrenheitToCelsius();
    	    } else {
    	        convertCelsiusToFahrenheit();
    	    }

            System.out.println("Do you want to calculate again? (yes/no)");
            continueCalculating = wantContinue();
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
                if (choice == faherenheitToCelsius) {
                    return choice;
                } else {
                    if (choice == celsiusToFaherenheit) {
                        return choice;
                    }
                }
            } else {
                scan.next(); 
            }
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    static void convertFahrenheitToCelsius() {
        double fahrenheit;
        while (true) {
            System.out.print("Enter Fahrenheit value: ");
            try {
                fahrenheit = scan.nextDouble();
                break;  
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scan.nextLine();  
            }
        }
        double celsius = fahrenheitToCelsius(fahrenheit);
        System.out.printf("%.1f°F is %.1f°C%n", fahrenheit, celsius);
    }

    static void convertCelsiusToFahrenheit() {
    	double celsius;
    	while (true) {
    		System.out.print("Enter Celsius value: ");
    		try {
    			celsius = scan.nextDouble();
    			break;
    		} catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scan.nextLine();  
    		}
    	}
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
        return Math.round(value * roundingFactor) / roundingFactor;
    }

    static boolean wantContinue() {
        while (true) {
            String input = scan.next().toLowerCase();
            if (input.equals("yes")) return true;
            if (input.equals("no")) return false;
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }
}
