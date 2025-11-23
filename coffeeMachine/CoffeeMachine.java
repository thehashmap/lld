package coffeeMachine;

import coffeeMachine.templateMethod.Coffee;

public class CoffeeMachine {
    private final static CoffeeMachine instance = new CoffeeMachine();
    private CoffeeMachineState state;
    private Coffee selectedCoffee;
    private int moneyInserted;

    public CoffeeMachine getInstance() {
        if(instance == null) {
            return new CoffeeMachine();
        }
        return instance;
    }
}
