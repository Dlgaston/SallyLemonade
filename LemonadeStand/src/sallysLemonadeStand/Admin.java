package sallysLemonadeStand;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements Accounts {
	String email = "dgaston@gmail.com";
	String password = "111";


	@Override
	public String email() {
		return email;
	}

	@Override
	public String password() {
		return password;
	}

	public static void adminPriveledge(Scanner scanner, Accounts admin, Lemonade lemonade, Water water, Soda soda, Cookies cookies, Candy candy) {
		if(adminLogin(scanner,admin) == true) {
			System.out.println("Would you like to check stock? y/n");
			String choice = scanner.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				stockChecker(scanner, lemonade, water, soda, cookies, candy);
				System.out.println("Would you like to add any stock? y/n ");
				choice = scanner.nextLine();
				if (choice.equalsIgnoreCase("y")) {
					stockAdder (scanner, lemonade, water, soda, cookies, candy);
				}
			} 




		}

	}
	public static boolean adminLogin(Scanner scanner, Accounts admin) {
		int attempt=0;
		System.out.println("Please enter Admin Email: ");
		while(attempt < 5) {
			String email = scanner.nextLine();
			if(email.equalsIgnoreCase(admin.email())) {
				System.out.println("Please enter Admin Password: ");
				String password = scanner.nextLine();
				if(password.equalsIgnoreCase(admin.password())) {
					return true;
				}	attempt++;


			} 		attempt++;



		}System.out.println("Wrong Email or Password. Goodbye!  ");
		return false;
	}

	public static void stockChecker(Scanner scanner, Lemonade lemonade, Water water, Soda soda, Cookies cookies, Candy candy) {
		lemonade.checkStock();
		water.checkStock();
		soda.checkStock();
		cookies.checkStock();
		candy.checkStock();


	}
	public static void stockAdder (Scanner scanner, Lemonade lemonade, Water water, Soda soda, Cookies cookies, Candy candy) {
		System.out.println("Which product would you like to add stock too?");
		System.out.println("1: Lemonade 2: Water 3: Soda");
		System.out.println("4: Cookies 5: Candy 6: Exit");
		int choice = scanner.nextInt();

		switch(choice) {
		case 1: System.out.println("How much would you like to add? ");
		int amount = scanner.nextInt();
		lemonade.addToStock(amount);
		lemonade.checkStock();
		break;

		case 2:System.out.println("How much would you like to add? ");
		amount = scanner.nextInt();
		water.addToStock(amount);
		water.checkStock();
		break;

		case 3: System.out.println("How much would you like to add? ");
		amount = scanner.nextInt();
		soda.addToStock(amount);
		soda.checkStock();
		break; 

		case 4:	System.out.println("How much would you like to add? ");
		amount = scanner.nextInt();
		cookies.addToStock(amount);
		cookies.checkStock();
		break; 

		case 5: System.out.println("How much would you like to add? ");
		amount = scanner.nextInt();
		candy.addToStock(amount);
		candy.checkStock();
		break;


		}
	}
	public static void customerAccountSheet(Scanner scanner, Admin admin, ArrayList<Customer> customerAccount) {
    	if(adminLogin(scanner,admin) == true) {
    		for(Customer account : customerAccount) {
    			System.out.println("Account name:" + account + " Rewards:  " + account.getRewards()+ "/ Lifetime spendings : $" + account.getAmountSpent());
    			System.out.println();
    				
    		} 
    			
    		
    		
    	}


}
}
