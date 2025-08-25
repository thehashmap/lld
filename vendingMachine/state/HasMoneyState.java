package vendingMachine.state;

import vendingMachine.VendingMachine;
import vendingMachine.enums.Coin;

public class HasMoneyState extends VendingMachineState{
    public HasMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Amount received already");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected!");
    }

    @Override
    public void dispense() {
        vendingMachine.setVendingMachineState(new DispenseState(vendingMachine));
        vendingMachine.dispenseItem();
    }

    @Override
    public void refund() {
        vendingMachine.refundBalance();
        vendingMachine.reset();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    }
}
