package coffeeMachine.entity.templateMethod;

import coffeeMachine.enums.Ingredient;

import java.util.Map;

public abstract class Coffee {
    public String coffeeType;

    public String getCoffeeType() {
        return coffeeType;
    }

    public void prepare() {
        System.out.println("Preparing your " + this.coffeeType + " !");
        grindBeans();
        brew();
        addCondiments();
        pourIntoCup();
        System.out.println("Your " + this.coffeeType + " is ready!");
    }

    private void grindBeans() {
        System.out.println("Grinding Beans");
    }

    private void brew() {
        System.out.println("Brewing Coffee");
    }

    private void pourIntoCup() {
        System.out.println("Pouring in your cup");
    }

    protected abstract void addCondiments();

    public abstract int getPrice();

    public abstract Map<Ingredient, Integer> getRecipe();


}
