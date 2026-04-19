package sample;
import java.util.Scanner;

public class SumEvenOdd {
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);



     System.out.println("Enter the number of integers: ");

     int n = sc.nextInt();



     int evenSum = 0, oddSum = 0;



     System.out.println("Enter " + n + " integers:");

     for (int i = 0; i < n; i++) {

         int num = sc.nextInt();

         if (num % 2 == 0)

             evenSum += num;

         else

             oddSum += num;

     }



     System.out.println("Sum of even numbers: " + evenSum);

     System.out.println("Sum of odd numbers: " + oddSum);

     sc.close();
}
}
