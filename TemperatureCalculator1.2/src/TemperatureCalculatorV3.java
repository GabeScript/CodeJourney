
public class TemperatureCalculatorV3 {
	public static void main(String[] args) {
        CalculatorScript cs = new CalculatorScript();
    	boolean continueCalculating = true;
    	while (continueCalculating) {
    	    cs.showMainMenu();
    	    int choice = cs.getValidChoice();

    	    if (choice == 1) {
    	        cs.convertFahrenheitToCelsius();
    	    } else {
    	        cs.convertCelsiusToFahrenheit();
    	    }

            System.out.println("Do you want to calculate again? (yes/no)");
            continueCalculating = cs.wantContinue();
        }

        System.out.println("Thank you for using the temperature calculator");
    }
}