import java.util.Scanner;

public class ConversionScript {
	public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	temperatureCalculator mainMenu = new temperatureCalculator();
    	temperatureCalculator validChoice = new temperatureCalculator();
    	temperatureCalculator calcFC = new temperatureCalculator();
    	temperatureCalculator calcCF = new temperatureCalculator();
    	temperatureCalculator contin = new temperatureCalculator();
    	boolean continueCalculating = true;
    	while (continueCalculating) {
    	    mainMenu.showMainMenu();
    	    int choice = validChoice.getValidChoice();

    	    if (choice == 1) {
    	        calcFC.convertFahrenheitToCelsius();
    	    } else {
    	        calcCF.convertCelsiusToFahrenheit();
    	    }

            System.out.println("Do you want to calculate again? (yes/no)");
            continueCalculating = contin.wantContinue();
        }

        System.out.println("Thank you for using the temperature calculator");
        scan.close();
    }
}