package sallysLemonadeStand;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements Accounts {
	String email;
	String password;
	int rewards;
	double amountSpent;

	public double getAmountSpent() {
		return amountSpent;
	}
	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}
	Customer() {}
	Customer(int rewards){}

	public String getEmail() {
		return email;
	}

	public int getRewards() {
		return rewards;
	}

	public void setRewards(int rewards) {
		this.rewards = rewards;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String email() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public String password() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String toString() {
		return email;
	}

	public static void signupCustomer(Scanner scanner, ArrayList<Customer> customerAccount) {
		String choice;
		
		System.out.println("Would you like to create a new customer account? y/n");
		choice = scanner.nextLine();
		if (choice.equalsIgnoreCase("y")) {
			Customer account = new Customer();
			System.out.println("Please enter an email for your account. ");
			account.setEmail(scanner.nextLine());
			System.out.println("Is " + account.getEmail() + " correct? y/n");
			choice = scanner.nextLine();
			if(choice.equalsIgnoreCase("y")) {
				System.out.println("Please enter a password for your account. ");
				account.setPassword(scanner.nextLine());
				System.out.println("Is " + account.getPassword() + " correct? y/n");
				choice = scanner.nextLine();
				if(choice.equalsIgnoreCase("y")) {
					account.setRewards(0);
					account.setAmountSpent(0);
					customerAccount.add(account);
					
				}
			}
		}	
	}
	public static boolean customerSignin(Scanner scanner, ArrayList<Customer> customerAccount) {
		System.out.println("Are you enrolled in our Rewards Program? y/n");
		String choice = scanner.nextLine();
		String email;
		String password;

		if (choice.equalsIgnoreCase("y")) {
			System.out.println("Please enter email and password: ");
			System.out.println("Email: ");
			email = scanner.nextLine();

			for (Customer account : customerAccount) {
				if(email.equalsIgnoreCase(account.email)) {
					System.out.println("Password: ");
					password = scanner.nextLine();
					if(password.equalsIgnoreCase(account.password)) {
						return true;
					}

				}
			}

		}
		return false;

	} 
	public static void customerRewards(Scanner scanner, ArrayList<Customer> customerAccount) {
		
	}

}