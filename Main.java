package bank;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Bank obj = new Bank();

		boolean keepRunning = true;

		while (keepRunning) {
			System.out.println("\nWelcome to Meezan Bank Limited");
			System.out.println("******************************");
			System.out.println("1. Create Account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("Enter choice");
			int choice = scan.nextInt();
			switch (choice) {
				case 1:
					obj.CreateAccount();
					break;
				case 2:
					obj.Login();
					break;
				case 3:
					System.out.println("Thank you for using Meezan Bank. Have a nice day!");
					keepRunning = false;
					break;
				default:
					System.out.println("Invalid choice entered");
			}
		}
	}
}
