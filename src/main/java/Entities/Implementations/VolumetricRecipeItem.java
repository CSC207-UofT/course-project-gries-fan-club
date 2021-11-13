package Entities.Implementations;

import Entities.Ingredient;

import java.util.UUID;

public class VolumetricRecipeItem extends AbstractRecipeItem {

    /**
     * Implements RecipeItem that is measured by volume in ml, giving the ingredient,
     * quantity of this ingredient, and if the ingredient is optional.
     *
     * @param ingredient The ingredient
     * @param amount     The quantity of this ingredient as float.
     * @param optional   Is the ingredient optional?
     */
    public VolumetricRecipeItem(Ingredient ingredient, float amount, boolean optional) {
        super(ingredient, amount, optional);
    }

    public VolumetricRecipeItem(UUID id, Ingredient ingredient, float amount, boolean optional) {
        super(id, ingredient, amount, optional);
    }

    public String display(){
        float tempQuantity = this.quantity();
        String stringQuantity;

        // checks if the quantity ends in .0 or .00 (whole number)
        if (this.quantity() % 1 == 0) {
            // make it an int to remove the decimal
            stringQuantity = Integer.toString((int) tempQuantity);
        } else {
            // Convert to a string for returning
            stringQuantity = Float.toString(tempQuantity);
        }
        return stringQuantity + "ml of " + this.ingredient().name();
    }

}
