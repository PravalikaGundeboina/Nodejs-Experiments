package sample;
import java.util.Scanner;
public class PrimeFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");

        int n = sc.nextInt();

        System.out.println("Prime numbers between 1 and " + n + " that are also in Fibonacci series:");

        boolean[] isFibo = new boolean[n + 1];

        int a = 0, b = 1, c;

        while (a <= n) {

            isFibo[a] = true;

            c = a + b;

            a = b;

            b = c;

        }

        for (int num = 2; num <= n; num++) {

            boolean isPrime = true;

            for (int i = 2; i <= num / 2; i++) {

                if (num % i == 0) {

                    isPrime = false;

                    break;

                }

            }

            if (isPrime && isFibo[num]) {

                System.out.print(num + " ");

            }

        }

        sc.close();
	}

}
