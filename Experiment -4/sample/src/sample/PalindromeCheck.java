package sample;
import java.util.Scanner;

public class PalindromeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a String: ");

	        String original = sc.nextLine();

	        String reversed = "";

	        for (int i = original.length() - 1; i >= 0; i--) {

	            reversed = reversed + original.charAt(i);

	        }

	        if (original.equals(reversed)) {

	            System.out.println("The given string is a Palindrome.");

	        } else {

	            System.out.println("The given string is NOT a Palindrome.");

	        }

	 

	        sc.close();
	}

}
