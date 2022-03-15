package sallysLemonadeStand;

public interface ProductInterface {

    public double sellProduct(int amountOfItems);
    public void checkStock();
    public void addToStock(int amount);
    public void removeFromStock(int amountOfItems);
    public static void pay() {
        System.out.println("***********CUSTOMER PAYING***************");
    }
}
