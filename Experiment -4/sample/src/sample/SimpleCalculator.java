package sample;
import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        boolean running = true;

        System.out.println("Simple Calculator ");

        while (running) {

            System.out.println("Enter First number:");

            double num1 = sc.nextDouble();

            System.out.println("Enter Second number:");

            double num2 = sc.nextDouble();

            System.out.println("Enter the operation you want to perform (+, -, *, /) or type 'exit' to quit:");

            String operation = sc.next();

            double result;



            switch (operation) {

                case "+":

                    result = num1 + num2;

                    System.out.println("Result: " + result);

                    break;

                case "-":

                    result = num1 - num2;

                    System.out.println("Result: " + result);

                    break;

                case "*":

                    result = num1 * num2;

                    System.out.println("Result: " + result);

                    break;

                case "/":

                    if (num2 != 0) {

                        result = num1 / num2;

                        System.out.println("Result: " + result);

                    } else {

                        System.out.println("Error: Can't be divided by zero!");

                    }

                    break;

                case "exit":

                    running = false;  // stops the loop

                    System.out.println("Calculator exited");

                    break;

                default:

                    System.out.println("Invalid Operation!");

            }

        }



        sc.close();
	}

}
