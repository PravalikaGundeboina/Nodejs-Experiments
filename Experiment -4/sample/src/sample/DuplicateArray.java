package sample;
import java.util.Scanner;
public class DuplicateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");

        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers:");

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();

        }

        System.out.print("Duplicate values: ");

        boolean found = false;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] == arr[j]) {

                    System.out.print(arr[i] + " ");

                    found = true;

                    break;

                }

            }

        }

        if (!found) {

            System.out.print("None");

        }

        sc.close();

	}

}
