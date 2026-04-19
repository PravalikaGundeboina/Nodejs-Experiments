package sample;
import java.util.Scanner;
public class Electricity_bill {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter old reading:");

		int old_reading = sc.nextInt();

		System.out.println("Enter New reading:");

		int new_reading = sc.nextInt();

		int units = new_reading - old_reading;

		int bill =0 ;

		if(units<=50) {

			bill = units * 1;

			}

		else if(units <= 100) {

			bill=50*1+(units-50)*2;

		}

		else if(units<=200) {

			bill=50*1+50*2+(units-100)*3;

		}

		else if(units<=400) {

			bill=50*1+50*2+100*3+(units-200)*4;

		}

		else {

            bill = (50 * 1) + (50 * 2) + (100 * 3) + (200 
            		* 4) + (units - 400) * 5;

        }

		System.out.println("Units Consumed: " + units);

                System.out.println("Total Bill Obtained: Rs." + bill); 



	}

}
