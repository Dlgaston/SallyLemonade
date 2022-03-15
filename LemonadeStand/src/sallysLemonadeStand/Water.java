package sallysLemonadeStand;

public class Water implements ProductInterface {

    final static double COST = 1.00; // price
    int itemsInStock = 100;

    @Override
    public double sellProduct(int amountOfItems) {
        return amountOfItems*COST;
    }

    @Override
    public void checkStock() {
        System.out.println("You have " + itemsInStock + " Waters in stock");
    }

    @Override
    public void addToStock(int amount) {
        this.itemsInStock += amount;
    }

    @Override
    public void removeFromStock(int amountOfItems) {
        this.itemsInStock -= amountOfItems;
        
    }
}
