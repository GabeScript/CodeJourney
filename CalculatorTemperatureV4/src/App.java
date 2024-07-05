import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueCalculating = true;

        while (continueCalculating) {
            System.out.println("Fahrenheit to Celsius (f)");
            System.out.println("Celsius to Fahrenheit (c)");
            System.out.print("Enter unit (f/c): ");
            
            String tempUnit = scan.nextLine().toLowerCase();
            
            if (tempUnit.equals("f") || tempUnit.equals("c")) {
                System.out.print("Enter temperature: ");
                try {
                    double temperature = Double.parseDouble(scan.nextLine());
                    double result = conversor(tempUnit, temperature);
                    System.out.printf("Converted temperature: %.1f%n", result);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid temperature. Please enter a number.");
                    continue;
                }
            } else {
                System.out.println("Invalid input. Please enter 'f' or 'c'.");
                continue;
            }

            System.out.println("Do you want to calculate again? (yes/no)");
            continueCalculating = wantContinue();
        }
        System.out.println("Thank you for using the temperature calculator");

        scan.close();
    }

    static double conversor(String tempUnit, double temperature) {
        
            if (tempUnit.equals("f")) {
                return (temperature - 32) * 5 / 9; 
            } else if (tempUnit.equals("c")) {
                return (temperature * 9 / 5) + 32; 
            } else {
                throw new IllegalArgumentException("Invalid temperature unit");
            }
 
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