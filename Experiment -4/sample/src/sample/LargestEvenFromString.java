package sample;
import java.util.Scanner;

public class LargestEvenFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");

        String str = sc.nextLine();

        boolean[] digitSeen = new boolean[10];

        int[] digits = new int[10];

        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch >= '0' && ch <= '9') {

                int d = ch - '0';

                if (!digitSeen[d]) {       

                    digitSeen[d] = true;

                    digits[count] = d;

                    count++;

                }

            }

        }

        if (count == 0) {

            System.out.println("-1");

            return;

        }

        for (int i = 0; i < count - 1; i++) {

            for (int j = 0; j < count - i - 1; j++) {

                if (digits[j] < digits[j + 1]) {

                    int temp = digits[j];

                    digits[j] = digits[j + 1];

                    digits[j + 1] = temp;

                }

            }

        }

        int evenIndex = -1;

        for (int i = count - 1; i >= 0; i--) {

            if (digits[i] % 2 == 0) {

                evenIndex = i;

                break;

            }

        }

        if (evenIndex == -1) {

            System.out.println("-1");

        } else {

            int evenDigit = digits[evenIndex];

            for (int i = evenIndex; i < count - 1; i++) {

                digits[i] = digits[i + 1];

            }

            digits[count - 1] = evenDigit;

            System.out.print("Largest even number: ");

            for (int i = 0; i < count; i++) {

                System.out.print(digits[i]);

            }

            System.out.println();

        }



        sc.close();
	}

}
