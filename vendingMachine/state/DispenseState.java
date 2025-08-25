package vendingMachine.state;

import vendingMachine.VendingMachine;
import vendingMachine.enums.Coin;

public class DispenseState extends VendingMachineState{
    public DispenseState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Dispense in progress");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Dispense in progress");
    }

    @Override
    public void dispense() {
        // implemented in HasMoneyState
    }

    @Override
    public void refund() {
        System.out.println("Dispense in progress");
    }
}
