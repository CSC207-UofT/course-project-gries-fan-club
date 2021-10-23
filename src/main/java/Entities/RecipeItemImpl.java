package Entities;

import EntityInterfaces.Ingredient;
import EntityInterfaces.RecipeItem;

import java.util.UUID;

public class RecipeItemImpl extends AbstractEntity  implements RecipeItem {
    private Ingredient ingredient;
    private int quantity;
    private boolean optional = false;

    /** Implement a ItemImpl, giving the ingredient, and
     * quantity of this ingredient.
     * This constructor includes the ID
     * @param id          The UUID of the item
     * @param ingredient  The ingredient
     * @param quantity     The quantity of this ingredient
     */
    public RecipeItemImpl(UUID id, Ingredient ingredient, int quantity) {
        super(id);
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    /** Implement a ItemImpl, giving the ingredient,
     * quantity of this ingredient, and if the ingredient is optional.
     * This constructor includes the ID.
     * @param id          The UUID of the item
     * @param ingredient  The ingredient
     * @param quantity    The quantity of this ingredient
     * @param optional    Is the ingredient optional?
     */
    public RecipeItemImpl(UUID id, Ingredient ingredient, int quantity, boolean optional) {
        super(id);
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.optional = optional;
    }


    /** Implement a ItemImpl, giving the ingredient, and
     * quantity of this ingredient.
     * @param ingredient  The ingredient
     * @param quantity     The quantity of this ingredient
     */
    public RecipeItemImpl(Ingredient ingredient, int quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    /** Implement a ItemImpl, giving the ingredient,
     * quantity of this ingredient, and if the ingredient is optional.
     * @param ingredient  The ingredient
     * @param quantity     The quantity of this ingredient
     * @param optional  Is the ingredient optional?
     */
    public RecipeItemImpl(Ingredient ingredient, int quantity, boolean optional) {
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
    public boolean optional() {
        return this.optional;
    }
}
