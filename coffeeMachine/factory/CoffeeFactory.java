package coffeeMachine.factory;

import coffeeMachine.templateMethod.Cappuccino;
import coffeeMachine.templateMethod.Coffee;
import coffeeMachine.templateMethod.Espresso;
import coffeeMachine.templateMethod.Latte;
import coffeeMachine.enums.CoffeeType;

public class CoffeeFactory {
    public static Coffee createCoffee(CoffeeType type) {
        switch (type) {
            case ESPRESSO -> {
                return new Espresso();
            }
            case LATTE -> {
                return new Latte();
            }
            case CAPPUCCINO -> {
                return new Cappuccino();
            }
            default -> throw new IllegalArgumentException("Unsupported Coffee Type!");
        }
    }
}
