import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueCalculating = true;

        while (continueCalculating) {
            String tempUnit = getTempUnit();
            double temperature = getTemperature();
            
            double result = conversor(tempUnit, temperature);
            System.out.printf("Converted temperature: %.1f%n", result);

            continueCalculating = wantContinue();
        }
        System.out.println("Thank you for using the temperature calculator");

        scan.close();
    }

    public static String getTempUnit() {
        while (true) {
            System.out.println("Fahrenheit to Celsius (f)");
            System.out.println("Celsius to Fahrenheit (c)");
            System.out.print("Enter unit (f/c): ");
            
            String tempUnit = scan.nextLine().toLowerCase();
            
            if (tempUnit.equals("f") || tempUnit.equals("c")) {
                return tempUnit;
            } else {
                System.out.println("Invalid input. Please enter 'f' or 'c'.");
            }
        }
    }

    public static double getTemperature() {
        while (true) {
            System.out.print("Enter temperature: ");
            try {
                return Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature. Please enter a number.");
            }
        }
    }

    public static double conversor(String tempUnit, double temperature) {
        if (tempUnit.equals("f")) {
            return (temperature - 32) * 5 / 9; // Fahrenheit to Celsius
        } else {
            return (temperature * 9 / 5) + 32; // Celsius to Fahrenheit
        }
    }

    public static boolean wantContinue() {
        while (true) {
            System.out.print("Do you want to calculate again? (yes/no): ");
            String input = scan.nextLine().toLowerCase();
            if (input.equals("yes")) return true;
            if (input.equals("no")) return false;
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }
}