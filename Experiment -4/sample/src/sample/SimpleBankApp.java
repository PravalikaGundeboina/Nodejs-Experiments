package sample;

import java.util.Scanner;

public class SimpleBankApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxAccounts = 100;
        int[] accountNumbers = new int[maxAccounts];
        String[] names = new String[maxAccounts];
        String[] aadharNumbers = new String[maxAccounts];
        String[] panNumbers = new String[maxAccounts];
        double[] balances = new double[maxAccounts];

        int accountCount = 0;
        int nextAccountNumber = 1001;  // start account numbers from 1001
        char choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Account Creation");
            System.out.println("2. Credit Amount");
            System.out.println("3. Debit Amount");
            System.out.println("4. Mini Statement / Balance Enquiry");
            System.out.println("5. Transfer Amount");
            System.out.println("6. Exit");
            System.out.print("Enter your option: ");

            int option = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (option) {
                case 1:
                    if (accountCount < maxAccounts) {
                        System.out.print("Enter Customer Name: ");
                        names[accountCount] = sc.nextLine();

                        System.out.print("Enter Aadhar Number: ");
                        aadharNumbers[accountCount] = sc.nextLine();

                        System.out.print("Enter PAN Number: ");
                        panNumbers[accountCount] = sc.nextLine();

                        accountNumbers[accountCount] = nextAccountNumber;
                        balances[accountCount] = 0.0;

                        System.out.println("Account Created Successfully!");
                        System.out.println("Your Account Number: " + nextAccountNumber);

                        nextAccountNumber++;
                        accountCount++;
                    } else {
                        System.out.println("Account limit reached.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int creditAcc = sc.nextInt();
                    System.out.print("Enter Amount to Credit: ");
                    double creditAmt = sc.nextDouble();

                    boolean creditFound = false;
                    for (int i = 0; i < accountCount; i++) {
                        if (accountNumbers[i] == creditAcc) {
                            balances[i] += creditAmt;
                            System.out.println("Amount Credited Successfully!");
                            creditFound = true;
                            break;
                        }
                    }
                    if (!creditFound) {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int debitAcc = sc.nextInt();
                    System.out.print("Enter Amount to Debit: ");
                    double debitAmt = sc.nextDouble();

                    boolean debitFound = false;
                    for (int i = 0; i < accountCount; i++) {
                        if (accountNumbers[i] == debitAcc) {
                            if (balances[i] >= debitAmt) {
                                balances[i] -= debitAmt;
                                System.out.println("Amount Debited Successfully!");
                            } else {
                                System.out.println("Insufficient Balance!");
                            }
                            debitFound = true;
                            break;
                        }
                    }
                    if (!debitFound) {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int balAcc = sc.nextInt();
                    boolean balFound = false;

                    for (int i = 0; i < accountCount; i++) {
                        if (accountNumbers[i] == balAcc) {
                            System.out.println("\n----- MINI STATEMENT -----");
                            System.out.println("Account Number: " + accountNumbers[i]);
                            System.out.println("Name: " + names[i]);
                            System.out.println("Balance: " + balances[i]);
                            balFound = true;
                            break;
                        }
                    }
                    if (!balFound) {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter FROM Account Number: ");
                    int fromAcc = sc.nextInt();
                    System.out.print("Enter TO Account Number: ");
                    int toAcc = sc.nextInt();
                    System.out.print("Enter Amount to Transfer: ");
                    double transAmt = sc.nextDouble();

                    int fromIndex = -1, toIndex = -1;
                    for (int i = 0; i < accountCount; i++) {
                        if (accountNumbers[i] == fromAcc) fromIndex = i;
                        if (accountNumbers[i] == toAcc) toIndex = i;
                    }

                    if (fromIndex != -1 && toIndex != -1) {
                        if (balances[fromIndex] >= transAmt) {
                            balances[fromIndex] -= transAmt;
                            balances[toIndex] += transAmt;
                            System.out.println("Amount Transferred Successfully!");
                        } else {
                            System.out.println("Insufficient Balance in FROM Account!");
                        }
                    } else {
                        System.out.println("Invalid Account Number(s)!");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the Bank Application!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Option!");
            }

            System.out.print("\nDo you want to continue? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        sc.close();
    }
}
