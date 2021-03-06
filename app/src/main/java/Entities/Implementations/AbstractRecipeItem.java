package Entities.Implementations;

import Entities.Ingredient;
import Entities.RecipeItem;

import java.util.UUID;

public abstract class AbstractRecipeItem extends AbstractEntity implements RecipeItem {
    private final Ingredient ingredient;
    private final float amount;
    private boolean optional = false;

    /**
     * @param amount of this ingredient.
     * @param ingredient  The ingredient
     *
     */
    public AbstractRecipeItem(Ingredient ingredient, float amount) {
       super();
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
        super();
        this.ingredient = ingredient;
        this.amount = amount;
        this.optional = optional;
    }

    public AbstractRecipeItem(UUID id, Ingredient ingredient, float amount, boolean optional) {
        super(id);
        this.ingredient = ingredient;
        this.amount = amount;
        this.optional = optional;
    }

    @Override
    public Ingredient ingredient() {
        return this.ingredient;
    }

    @Override
    public double quantity() {
        return this.amount;
    }

    @Override
    public boolean optional() {
        return this.optional;
    }
}
