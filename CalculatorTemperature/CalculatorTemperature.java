import java.util.Scanner;

public class CalculatorTemperature {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean continueCalculating = true;
		
		while(continueCalculating) {
			System.out.println("Fahrenheit to Celsius (1) or Celsius to Fahrenheit (2)");
			int result = scanner.nextInt();
			
			if (result == 1) {
				System.out.println("You have chose Fahrenheit to Celsius");
				System.out.println("Enter Fahrenheit value: ");
				double value = scanner.nextDouble();
				double finalvalue = (value - 32) * 5/9;
				System.out.print("Celsius is: ");
				System.out.println(Math.round(finalvalue*10.0)/10.0);
				
			} else if (result == 2) {
				System.out.println("You have chose Celsius to Fahrenheit");
				System.out.println("Enter Celsius value: ");
				double value2 = scanner.nextDouble();
				double finalvalue2 = (value2 * 9/5) + 32;
				System.out.print("Fahrenheit is: ");
				System.out.println(Math.round(finalvalue2 * 10.0)/10.0);
				
			} else {
				System.out.println("Not valid choice");
			}
			
			System.out.println("Do you want to calculate again? yes / no");
			String answer = scanner.next().toLowerCase();
			continueCalculating = answer.equals("yes");
			
		}
		
		System.out.println("Thanks you for using the temperature calculator");
		scanner.close();
	}

}
