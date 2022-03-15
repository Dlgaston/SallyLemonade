package sallysLemonadeStand;

import java.util.ArrayList;
import java.util.Scanner;

/* Notes for Bonus:
		    Users are of two types: Admin and Customer. An admin can check and update inventory.
		    You may create your own default admin user, but customers must signup
		    Users should have an email and password to verify to access rewards.
		    Do not worry about signing in, just signup and verify.
		    Admins should have to verify to access inventory functionality.
		    Users may be stored inside an array to be kept track of.
		    Sally said she would like it if you kept track of user's total $ spent as well
		    to make keeping track of rewards easy.
 * */
public class SallysLemonadeStand {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);			ArrayList<Customer> customerAccount = new ArrayList<Customer>();
		Lemonade lemonade = new Lemonade();					 Admin admin = new Admin();
		Water water = new Water();
		Soda soda = new Soda();
		Cookies cookies = new Cookies();
		Candy candy = new Candy();




		while(true) {
			System.out.println("Welcome to Sallys Lemonade Stand!");
			System.out.println("Please input your selection");
			System.out.println("1: Lemonade, 2: Water, 3: Soda, 4: Cookies, 5: Candy");
			System.out.println("Press 6 to sign up for a customer account WITH REWARDS!");
			System.out.println("Press 7 to login to Admin Account.");
			int choice = scanner.nextInt();
			scanner.nextLine();


			switch(choice) {
			case 1:
				customerEngagement(scanner, lemonade, customerAccount);
				break;
			case 2:
				customerEngagement(scanner, water, customerAccount);
				break;
			case 3:
				customerEngagement(scanner, soda, customerAccount);
				break;
			case 4:
				Cookies.cookieSale (scanner, cookies, customerAccount);
				break;
			case 5:
				customerEngagement(scanner, candy, customerAccount);
				break;
			case 6:
				Customer.signupCustomer(scanner, customerAccount);
				break;
			case 7: Admin.adminPriveledge(scanner, admin, lemonade,water,soda,cookies,candy);
			System.out.println("Would you like to see how many customers have signed up? y/n");
			String selection = scanner.nextLine();
			if(selection.equalsIgnoreCase("y")) {
				Admin.customerAccountSheet(scanner, admin, customerAccount);
			}


			break;

			}
		}

	}

	public static void customerEngagement(Scanner scanner, ProductInterface product, ArrayList<Customer> customerAccount) {
		System.out.println("Please input the quantity of your product you want: ");
		int amountOfItems = scanner.nextInt();
		double amountDue = product.sellProduct(amountOfItems);

		scanner.nextLine();
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
						if(account.getRewards() >= 10) {
							amountDue=amountDue-5;
							account.setRewards(account.getRewards() - 10);
						}

						account.setRewards(account.getRewards() + (int)amountDue);
						System.out.println("You have " + account.getRewards() + " Reward points!");
						account.setAmountSpent(account.getAmountSpent() + amountDue);
					}

				}

			}


		}


		System.out.println("Your cost is: " + amountDue);
		ProductInterface.pay();
		System.out.println("Thank you for shopping with Sallys!");
		product.removeFromStock(amountOfItems);







		System.out.println("yay it worked");

	}




}

