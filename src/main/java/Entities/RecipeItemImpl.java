package Entities;

public class RecipeItemImpl implements RecipeItem {
    private Ingredient ingredient;
    private int quantity;
    private boolean optional = false;

    /** Implement a ItemImpl, giving the ingredient, and
     * quantity of this ingredient.
     *
     * @param ingredient  The ingredient
     *
     * @param quantity     The quantity of this ingredient
     */
    public RecipeItemImpl(Ingredient ingredient, int quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    /** Implement a ItemImpl, giving the ingredient,
     * quantity of this ingredient, and if the ingredient is optional.
     *
     * @param ingredient The ingredient
     *
     * @param quantity The quantity of this ingredient
     *
     * @param optional Is the ingredient optional
     */
    public RecipeItemImpl(Ingredient ingredient, int quantity, boolean optional) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.optional = optional;
    }

    /**
     * Returns the ingredient of the RecipeItemImpl
     *
     * @return Ingredient instance
     */
    @Override
    public Ingredient ingredient() {
        return this.ingredient;
    }

    /**
     * Returns the quantity of the RecipeItemImpl
     *
     * @return int representing quantity
     */
    @Override
    public int quantity() {
        return this.quantity;
    }

    /**
     * Returns whether the ingredient is optional
     *
     * @return boolean representing if optional
     */
    @Override
    public boolean optional() {
        return this.optional;
    }
}
