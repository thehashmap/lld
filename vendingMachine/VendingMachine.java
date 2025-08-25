package vendingMachine;

import vendingMachine.entity.Inventory;
import vendingMachine.entity.Item;
import vendingMachine.enums.Coin;
import vendingMachine.state.IdleState;
import vendingMachine.state.VendingMachineState;

public class VendingMachine {
    private final static VendingMachine instance = new VendingMachine();
    private final Inventory inventory = new Inventory();
    private VendingMachineState vendingMachineState;
    private int balance = 0;
    private String selectedItemCode;

    public VendingMachine() {
        this.vendingMachineState = new IdleState(instance);
    }

    public static VendingMachine getInstance() {
        if(instance == null) {
            return new VendingMachine();
        }
        return instance;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setVendingMachineState(VendingMachineState state) {
        this.vendingMachineState = state;
    }

    public int getBalance() {
        return balance;
    }

    public String getSelectedItemCode() {
        return selectedItemCode;
    }

    public void setSelectedItemCode(String code) {
        this.selectedItemCode = code;
    }

    public void insertCoin(Coin coin) {
        balance += coin.getValue();
    }

    public Item addItem(String code, String name, int price) {
        Item item = new Item(code, name, price);
        inventory.addItem(code, item, price);
        return item;
    }

    public void dispenseItem() {
        Item item = inventory.getItem(selectedItemCode);
        if(balance >= item.getPrice()) {
            inventory.reduceStock(item.getCode());
            balance -= item.getPrice();
            System.out.println("Dispensed: " + item.getName());
            if (balance > 0) {
                System.out.println("Returning change: " + balance);
            }
        }
        reset();
        setVendingMachineState(new IdleState(this));
    }

    public void addBalance(Coin coin) {
        this.balance += coin.getValue();
    }

    public Item getSelectedItem() {
        return inventory.getItem(selectedItemCode);
    }

    public void reset() {
        selectedItemCode = null;
        balance = 0;
    }

    public void refundBalance() {
        System.out.println("Refund amount: " + balance);
        balance = 0;
    }
}
