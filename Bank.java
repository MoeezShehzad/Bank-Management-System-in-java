package bank;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Bank {

	Scanner scanner = new Scanner(System.in);
	
	// Account Variables
	ArrayList<String> user = new ArrayList<String>();
//	ArrayList<String> BankId = new ArrayList<String>();
	String BankId ;
	
	// calculation variables
	private double amount = 0;
	private double withdraw = 0;
	private int pin;
	int choice;
	
	// Verification Variables
	String id_verification;
	int pin_verification;
	
	// Boolean Variables
	boolean keepRunning = true;

//	public void FileCreation() {
//		try {
//			File f = new File("C:\\Users\\Moeez\\Desktop\\java\\", "Accounts");
//		}
//	}
	
	public void CreateAccount() {
		
		System.out.println("Enter Name:");
		user.add(scanner.nextLine());
		System.out.println("Enter Bank id: ");
		BankId = scanner.nextLine();
		System.out.println("Create a Pin"); // for authentication
		pin = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Account Created Successfully");
	}

	// Deposit function
	public void Deposit() {
		while(true) {
		try {
			System.out.println("Enter amount to deposit:");
			amount = scanner.nextDouble();
			if(amount < 500)
				throw new Exception();
			else
				System.out.print("Amount Deposited: " + amount);
			break;
		}catch(Exception e) {
			System.out.println("Amount must be greater than 500 Min");
		}
	}
		
}

	// Withdraw function
	public void Withdraw() {
		System.out.println("Enter Amount to Withdraw");
		withdraw = scanner.nextDouble();
		if (amount == 0) {
			System.out.println("Your account is empty " + amount);
			System.out.println("Do you want to Deposit money? \n1. Yes \n2. No");
			choice = scanner.nextInt();
			if (choice == 1) {
				Deposit();
			} else {
				System.out.println("Thank you for using ATM. Exiting..");
				scanner.close();
			}
		} else {
			amount -= withdraw;
		}
	}

	// information checking function
	public void check() {
		for(int i=0; i<user.size(); i++) {
			System.out.println("UserName: " + user.get(i));			
			System.out.println("ID: " + BankId);
			System.out.println("Amount:" + amount);
		}
	}
	
	public void Login() {
		System.out.print("Enter Bankid:");
		id_verification = scanner.nextLine();
		System.out.print("Enter Pin");
		pin_verification = scanner.nextInt();
		
		if(BankId == null) {
			System.out.println("------Please Create an Account first.------");
		}
		else {
			if (BankId.equals(id_verification) && pin_verification == pin) {
			System.out.println("Login Successful, Welcome "+user);
			
			while(keepRunning) {
				System.out.println("\n1. Deposit Amount");
				System.out.println("2. Withdraw Money");
				System.out.println("3. Show Details");
				System.out.println("4. Exit");
				System.out.println("Enter choice");
				int choice = scanner.nextInt();
			switch(choice) {
			
				case 1:
					Deposit();
					break;
				case 2:
					Withdraw();
					break;
				case 3:
					check();
					break;
				case 4:
					System.out.println("Thank you for using Meezan Bank. Have a nice day!");
					keepRunning = false;
					break;
				default:
					System.out.println("Invalid choice entered");
					}
				}
			}
			else
				System.out.println("------Login Failed------");
		}
		
	}

}
