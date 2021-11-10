package Entities.Implementations;

import Entities.Ingredient;
import EntityInterfaces.RecipeItem;

public abstract class AbstractRecipeItem implements RecipeItem {
    private  Ingredient ingredient;
    private float amount;
    private boolean optional = false;

    /**
     * @param amount of this ingredient.
     * @param ingredient  The ingredient
     *
     */
    public AbstractRecipeItem(Ingredient ingredient, float amount) {
       this.ingredient = ingredient;
        this.amount = amount;
    }
    /**
     * quantity of this ingredient, and if the ingredient is optional.
     * @param ingredient  The ingredient
     * @param amount     The quantity of this ingredient
     * @param optional  Is the ingredient optional in the recipe?
     */
    public AbstractRecipeItem(Ingredient ingredient, float amount, boolean optional) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.optional = optional;
    }

    @Override
    public Ingredient ingredient() {
        return this.ingredient;
    }

    @Override
    public float quantity() {
        return this.amount;
    }

    @Override
    public boolean optional() {
        return this.optional;
    }
}