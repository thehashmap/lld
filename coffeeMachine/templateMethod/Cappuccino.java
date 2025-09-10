package coffeeMachine.entity.templateMethod;

import coffeeMachine.enums.Ingredient;

import java.util.Map;

public class Cappuccino extends Coffee{
    public Cappuccino() {
        this.coffeeType = "Cappuccino";
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding milk and foam");
    }

    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return Map.of(Ingredient.COFFEE_BEANS, 7, Ingredient.WATER,30,
                Ingredient.MILK, 20, Ingredient.CREAM, 10);
    }


}
