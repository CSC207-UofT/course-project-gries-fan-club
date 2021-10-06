package main.java.DataEntities;

public abstract class AbstractRecipeItem implements RecipeItem {

    private final Ingredient ingredient;
    private final float quantity;
    private final boolean optional;

    AbstractRecipeItem(float quantity, boolean optional, Ingredient ingredient) {
        this.quantity = quantity;
        this.optional = optional;
        this.ingredient = ingredient;
    }

    @Override
    public Ingredient ingredient() {
        return this.ingredient;
    }

    @Override
    public float quantity() {
        return this.quantity;
    }

    @Override
    public boolean optional() {
        return this.optional;
    }

}
