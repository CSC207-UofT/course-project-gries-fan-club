package Entities;

import EntityInterfaces.Ingredient;
import EntityInterfaces.RecipeItem;

public abstract class AbstractRecipeItem implements RecipeItem {
    public Ingredient ingredient;
    public float amount;
    public boolean optional = false;

    /** Implement a ItemImpl, giving the ingredient, and
     * quantity of this ingredient.
     * @param ingredient  The ingredient
     * @param amount     The quantity of this ingredient
     */
    //public AbstractRecipeItem(Ingredient ingredient, float amount) {
     //   this.ingredient = ingredient;
       // this.amount = amount;
    //}
    /** Implement a ItemImpl, giving the ingredient,
     * quantity of this ingredient, and if the ingredient is optional.
     * @param ingredient  The ingredient
     * @param amount     The quantity of this ingredient
     * @param optional  Is the ingredient optional?
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
