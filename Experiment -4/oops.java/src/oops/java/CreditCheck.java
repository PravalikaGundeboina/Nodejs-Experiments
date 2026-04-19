package oops.java;

import java.util.Scanner;
class CreditsNotSufficientException extends Exception {
    CreditsNotSufficientException(String message) {
        super(message);
    }
}
public class CreditCheck {
  static void checkCredits(int credits) throws CreditsNotSufficientException {
        if (credits < 50) {
            throw new CreditsNotSufficientException("Credits are less than 50!");
        } else {
            System.out.println("Credits are sufficient.");
        }
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter the number of Test cases : ");
    	int T = sc.nextInt();
    	while(T>0) {
        System.out.print("Enter the Credits : ");
        int credits = sc.nextInt();
        try {
            checkCredits(credits);
            System.out.println("You can register for the course!");
        } 
        catch (CreditsNotSufficientException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        System.out.println("Program ended.\n");
        T--;
    }
    }
}

