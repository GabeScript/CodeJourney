import java.util.Scanner;

public class ConversionScript {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean continueCalculating = true;

        while (continueCalculating) {
            System.out.println("Fahrenheit to Celsius (1) or Celsius to Fahrenheit (2)");
            int result = scan.nextInt();

            if (result == 1) {
                System.out.println("You have chosen FAHRENHEIT to CELSIUS");
                System.out.println("Enter fahrenheit value: ");
                double value = scan.nextDouble();
                double valuefinal = (value - 32) * 5/9;
                System.out.print("Celsius is: ");
                System.out.println(Math.round(valuefinal*10.0)/10.0);

            } else if (result == 2) {
                System.out.println("You have chosen CELSIUS to FAHRENHEIT");
                System.out.println("Enter celsius value: ");
                double value2 = scan.nextDouble();
                double finalvalue = (value2 * 9/5) + 32;
                System.out.print("Fahrenheit is: ");
                System.out.println(Math.round(finalvalue*10.0)/10.0);

            } else {
                System.out.println("Not valid choice");
            }

            System.out.println("Do you want to calculate again? yes/no");
            String answer = scan.next().toLowerCase();
            continueCalculating = answer.equals("yes");
        }

        System.out.println("Thank you for using the temperature calculator");
        scan.close();
    }
}