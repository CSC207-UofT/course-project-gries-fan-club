/* Public class ItemImpl that implements the Item interface.
 */
package Entities;

import EntityInterfaces.Ingredient;
import EntityInterfaces.Item;

public class ItemImpl implements Item {
    private Ingredient ingredient;
    private int quantity;
    private Boolean optional = false;

    public ItemImpl(Ingredient ingredient, int quantity) {
        /* Implement a ItemImpl, giving the ingredient, and
         * quantity of this ingredient.
         * @param ingredient  The ingredient
         * @param quantity     The quantity of this ingredient
         */
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public ItemImpl(Ingredient ingredient, int quantity, boolean optional) {
        /* Implement a ItemImpl, giving the ingredient,
         * quantity of this ingredient, and if the ingredient is optional.
         * @param ingredient  The ingredient
         * @param quantity     The quantity of this ingredient
         * @param optional  Is the ingredient optional?
         */
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
