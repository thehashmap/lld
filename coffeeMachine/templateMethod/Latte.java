package coffeeMachine.entity.templateMethod;

import coffeeMachine.enums.Ingredient;

import java.util.Map;

public class Latte extends Coffee {
    public Latte() {
        this.coffeeType = "Latte";
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding milk");
    }

    @Override
    public int getPrice() {
        return 70;
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return Map.of(Ingredient.COFFEE_BEANS, 5, Ingredient.WATER, 50, Ingredient.MILK, 40);
    }

}
