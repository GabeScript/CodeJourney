import java.util.Scanner;

public class TemperatureConverter {
    private Scanner scan;
    private boolean continueCalculating;
    private String tempUnit;
    private double temperature;

    public TemperatureConverter() {
        this.scan = new Scanner(System.in);
        this.continueCalculating = true;
    }

    public void run() {
        while (continueCalculating) {
            setTempUnit(getTempUnit());
            setTemperature(getTemperature());
            
            double result = convert();
            System.out.printf("Converted temperature: %.1f%n", result);

            setContinueCalculating(wantContinue());
        }
        System.out.println("Thank you for using the temperature calculator");

        scan.close();
    }

    private String getTempUnit() {
        while (true) {
            System.out.println("Fahrenheit to Celsius (f)");
            System.out.println("Celsius to Fahrenheit (c)");
            System.out.print("Enter unit (f/c): ");
            
            String input = scan.nextLine().toLowerCase();
            
            if (input.equals("f") || input.equals("c")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter 'f' or 'c'.");
            }
        }
    }

    private double getTemperature() {
        while (true) {
            System.out.print("Enter temperature: ");
            try {
                return Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature. Please enter a number.");
            }
        }
    }

    private double convert() {
        if (tempUnit.equals("f")) {
            return new FahrenheitToCelsius(temperature).convert();
        } else {
            return new CelsiusToFahrenheit(temperature).convert();
        }
    }

    private boolean wantContinue() {
        while (true) {
            System.out.print("Do you want to calculate again? (yes/no): ");
            String input = scan.nextLine().toLowerCase();
            if (input.equals("yes")) return true;
            if (input.equals("no")) return false;
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }

    public void setTempUnit(String tempUnit) {
        this.tempUnit = tempUnit;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setContinueCalculating(boolean continueCalculating) {
        this.continueCalculating = continueCalculating;
    }
}

