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

    public Item(Ingredient ingredient, int quantity, boolean optional) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.optional = optional;
    }

    @Override
    public Ingredient ingredient() {
        return this.ingredient;
    }

    @Override
    public int quantity() {
        return this.quantity;
    }

    @Override
    public Boolean optional(Boolean value) {
        return this.optional;
    }
}
