package sallysLemonadeStand;

import java.util.ArrayList;
import java.util.Scanner;

public class Cookies implements ProductInterface {

    double cost; // price
    int itemsInStock = 100;

    public void setCost(int amountOfItems) {
        if(amountOfItems == 3) {
           this.cost = 2;
        } else if (amountOfItems == 12) {
           this.cost = 6;
        }
       
		
    }
    @Override
    public double sellProduct(int amountOfItems) {
        return cost;
    }

    @Override
    public void checkStock() {
        System.out.println("You have " + itemsInStock + " cookie boxes in stock");
    }

    @Override
    public void addToStock(int amount) {
        this.itemsInStock += amount;
    }

    @Override
    public void removeFromStock(int amountOfItems) {
        this.itemsInStock -= amountOfItems;
       
    }
   
	public static void cookieSale(Scanner scanner, Cookies cookies, ArrayList<Customer> customerAccount) {
		System.out.println("Please input the quantity of cookies.  Either 3 or 12: ");
		int amountOfItems = scanner.nextInt();
		cookies.setCost(amountOfItems);
		double amountDue= cookies.sellProduct(amountOfItems);
		 System.out.println("Your cost is: " + amountDue);
	     ProductInterface.pay();
	     System.out.println("Thank you for shopping with Sallys!");
	     cookies.removeFromStock(amountOfItems);
		
	}

}
