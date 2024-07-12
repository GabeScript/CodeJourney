import java.util.InputMismatchException;
import  java.util.Scanner;

public class CalculatorScript {
    Scanner scan = new Scanner(System.in);
    void showMainMenu() {
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter your choice (1 or 2): ");
    }   

    double round(double value) {
        return Math.round(value * 10.0) / 10.0;
    }

    boolean wantContinue() {
        while (true) {
            String input = scan.next().toLowerCase();
            if (input.equals("yes")) return true;
            if (input.equals("no")) return false;
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }

    int getValidChoice() {
        while (true) {
            if (scan.hasNextInt()) {
                int choice = scan.nextInt();
                if (choice == 1) {
                    return choice;
                } else {
                    if (choice == 2) {
                        return choice;
                    }
                }
            } else {
                scan.next(); 
            }
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }	
    }

    void convertFahrenheitToCelsius() {
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
    	    }   double fahrenheitToCelsius(double fahrenheit) {
    	        return round((fahrenheit - 32) * 5 / 9);
    	    }

            void convertCelsiusToFahrenheit() {
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
    	    }      double celsiusToFahrenheit(double celsius) {
    	        return round((celsius * 9 / 5) + 32);
    	    }

    
}
