package Entities;

import EntityInterfaces.Ingredient;
import EntityInterfaces.Item;

public class ItemImpl implements Item {
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
    public Boolean optional() {
        return this.optional;
    }
}
