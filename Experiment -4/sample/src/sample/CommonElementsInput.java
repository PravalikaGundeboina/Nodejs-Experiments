package sample;
import java.util.Scanner;

public class CommonElementsInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter size of first array: ");

	        int n1 = sc.nextInt();

	        String[] array1 = new String[n1];

	        System.out.println("Enter elements of first array:");

	        for (int i = 0; i < n1; i++) {

	            array1[i] = sc.next();

	        }

	        System.out.print("Enter size of second array: ");

	        int n2 = sc.nextInt();

	        String[] array2 = new String[n2];

	        System.out.println("Enter elements of second array:");

	        for (int i = 0; i < n2; i++) {

	            array2[i] = sc.next();

	        }

	        System.out.println("Common elements:");

	        for (int i = 0; i < n1; i++) {

	            for (int j = 0; j < n2; j++) {

	                if (array1[i].equals(array2[j])) {

	                    System.out.println(array1[i]);

	                }
	               

	            }

	        }

	        sc.close();
	}

}
