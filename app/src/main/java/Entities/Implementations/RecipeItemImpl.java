package Entities.Implementations;

import Entities.Ingredient;
import Entities.ItemDisplays.RecipeItemDisplay;
import Entities.RecipeItem;

import java.util.UUID;

public class RecipeItemImpl extends AbstractEntity implements RecipeItem  {
    private final Ingredient ingredient;
    private final double amount;
    private boolean optional = false;
    private RecipeItemDisplay displayObject = null;

    /**
     * @param amount of this ingredient.
     * @param ingredient  The ingredient
     */
    public RecipeItemImpl(Ingredient ingredient, double amount, boolean optional, RecipeItemDisplay displayObject) {
        super();
        this.ingredient = ingredient;
        this.amount = amount;
        this.optional = optional;
        this.displayObject = displayObject;
    }

    public RecipeItemImpl(UUID id, Ingredient ingredient, double amount, boolean optional, RecipeItemDisplay displayObject) {
        super(id);
        this.ingredient = ingredient;
        this.amount = amount;
        this.optional = optional;
        this.displayObject = displayObject;
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

    @Override
    public String display() {
        return this.displayObject.display(this.amount, this.ingredient);
    }

    @Override
    public String serializeTypeCode() {
        if (this.displayObject != null)
            return this.displayObject.serializeTypeCode();
        return null;
    }
}
