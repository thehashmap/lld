package vendingMachine.state;

import vendingMachine.VendingMachine;
import vendingMachine.entity.Inventory;
import vendingMachine.entity.Item;
import vendingMachine.enums.Coin;

public class IdleState extends VendingMachineState {
    public IdleState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select an item first!");
    }

    @Override
    public void selectItem(String code) {
        if(vendingMachine.getInventory().isAvailable(code)) {
            vendingMachine.setSelectedItemCode(code);
            vendingMachine.setVendingMachineState(new ItemSelectedState(vendingMachine));
        } else {
            System.out.println("Item not available");
        }
    }

    @Override
    public void dispense() {
        System.out.println("No item selected!");
    }

    @Override
    public void refund() {
        System.out.println("No item selected!");
    }
}
