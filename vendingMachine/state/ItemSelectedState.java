package vendingMachine.state;

import vendingMachine.VendingMachine;
import vendingMachine.enums.Coin;

public class ItemSelectedState extends VendingMachineState {
    public ItemSelectedState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addBalance(coin);
        if(vendingMachine.getBalance() >= vendingMachine.getSelectedItem().getPrice()) {
            System.out.println("Sufficient amount received!");
            vendingMachine.setVendingMachineState(new HasMoneyState(vendingMachine));
        }
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected!");
    }

    @Override
    public void dispense() {
        System.out.println("No item selected!");
    }

    @Override
    public void refund() {
        vendingMachine.reset();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    }
}
