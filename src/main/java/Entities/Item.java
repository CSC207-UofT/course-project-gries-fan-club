package main.java.Entities;

import main.java.EntityInterfaces.ItemImpl;
import main.java.Entities.Ingredient;

public class Item implements ItemImpl {
    private Ingredient ingredient;
    private int quantity;
    private Boolean optional = false;

    public Item(Ingredient ingredient, int quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    @Override
    public Ingredient ingredientType() {
        return null;
    }

    @Override
    public int quantity() {
        return this.quantity;
    }

    @Override
    public Boolean optional(Boolean value) {
        this.optional = value;
        return this.optional;

    }
}
