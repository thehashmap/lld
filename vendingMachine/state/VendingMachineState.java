package vendingMachine.state;

import vendingMachine.VendingMachine;
import vendingMachine.enums.Coin;

public abstract class VendingMachineState {

    public VendingMachine vendingMachine;

    public VendingMachineState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public abstract void insertCoin(Coin coin);
    public abstract void selectItem(String code);
    public abstract void dispense();
    public abstract void refund();
}
