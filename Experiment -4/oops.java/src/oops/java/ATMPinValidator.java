package oops.java;

import java.util.Scanner;
class PinMisMatchException extends Exception {
 PinMisMatchException(String message) {
     super(message);
 }
}
public class ATMPinValidator {
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
     String accHolderName;
     int correctPin = 1234;
     int enteredPin;
     int attempts = 0;
     System.out.print("Enter Account Holder Name: ");
     accHolderName = sc.nextLine();
     while (attempts < 3) {
         System.out.print("Enter your 4-digit PIN: ");
         enteredPin = sc.nextInt();
         if (enteredPin == correctPin) {
             System.out.println("Welcome " + accHolderName + "! ");
             return; 
     }else {
             attempts++;
             System.out.println("Incorrect PIN. Attempt " + attempts + " of 3.");
        }
     }
     try {
         throw new PinMisMatchException("Sorry..Your Account Has been Locked");
     } catch (PinMisMatchException e) {
         System.out.println(e.getMessage());
     }         
     sc.close();    
 }
}

