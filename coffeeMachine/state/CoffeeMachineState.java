package coffeeMachine.state;

import coffeeMachine.CoffeeMachine;
import coffeeMachine.enums.CoffeeType;

public abstract class CoffeeMachineState {
    public CoffeeMachine coffeeMachine;

    public CoffeeMachineState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public abstract void selectCoffee(CoffeeType coffeeType);
    public abstract void insertMoney(int money);
    public abstract void dispense();

}
