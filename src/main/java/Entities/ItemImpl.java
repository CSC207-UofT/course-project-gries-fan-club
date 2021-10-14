package main.java.Entities;

import main.java.EntityInterfaces.Ingredient;

public class ItemImpl implements main.java.EntityInterfaces.Item {
    private Ingredient ingredient;
    private int quantity;
    private Boolean optional = false;

    public ItemImpl(Ingredient ingredient, int quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public ItemImpl(Ingredient ingredient, int quantity, boolean optional) {
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
