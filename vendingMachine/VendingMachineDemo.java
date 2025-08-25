package vendingMachine;

import vendingMachine.enums.Coin;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        vendingMachine.addItem("a1", "coke", 20);
        vendingMachine.addItem("b1", "pepsi", 20);
        vendingMachine.addItem("c1", "lays", 10);

        vendingMachine.setSelectedItemCode("c1");

        vendingMachine.insertCoin(Coin.TEN);

        vendingMachine.dispenseItem();
    }
}
