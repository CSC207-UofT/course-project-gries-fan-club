package Entities.Implementations;

import Entities.Ingredient;
import Entities.RecipeItem;
import java.util.UUID;
import Entities.RecipeItemDisplay;

public class RecipeItemImpl extends AbstractEntity implements RecipeItem  {
    private final Ingredient ingredient;
    private final float amount;
    private boolean optional = false;
    private RecipeItemDisplay type = null;

    /**
     * @param amount of this ingredient.
     * @param ingredient  The ingredient
     */
    public RecipeItemImpl(Ingredient ingredient, float amount, boolean optional, RecipeItemDisplay type) {
        super();
        this.ingredient = ingredient;
        this.amount = amount;
        this.optional = optional;
        this.type = type;
    }

    public RecipeItemImpl(UUID id, Ingredient ingredient, float amount, boolean optional, RecipeItemDisplay type) {
        super();
        this.ingredient = ingredient;
        this.amount = amount;
        this.optional = optional;
        this.type = type;
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

    @Override
    public String display() {
        return this.type.display(this.amount, this.ingredient);
    }

    @Override
    public String serializeTypeCode() {
        if (this.type != null)
            return this.type.serializeTypeCode();
        return null;
    }
}
