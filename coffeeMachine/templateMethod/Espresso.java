package coffeeMachine.entity.templateMethod;

import coffeeMachine.enums.Ingredient;

import java.util.Map;

public class Espresso extends Coffee {
    public Espresso() {
        this.coffeeType = "Espresso";
    }

    @Override
    protected void addCondiments() {
        // No extra condiments for espresso
    }

    @Override
    public int getPrice() {
        return 50;
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return Map.of(Ingredient.COFFEE_BEANS, 5, Ingredient.WATER, 50);
    }

}
