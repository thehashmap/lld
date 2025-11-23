package coffeeMachine.state;

import coffeeMachine.CoffeeMachine;
import coffeeMachine.enums.CoffeeType;

public class IdleState extends CoffeeMachineState{

    public IdleState(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    public void selectCoffee(CoffeeType coffeeType) {

    }

    @Override
    public void insertMoney(int money) {

    }

    @Override
    public void dispense() {

    }
}
