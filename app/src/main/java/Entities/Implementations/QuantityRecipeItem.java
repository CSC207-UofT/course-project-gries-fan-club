package Entities.Implementations;

import Entities.Ingredient;

import java.util.UUID;

public class QuantityRecipeItem extends AbstractRecipeItem {
    /**
     * Implements RecipeItem that is measured by whole units, giving the ingredient,
     * quantity of this ingredient, and if the ingredient is optional.
     *
     * @param ingredient The ingredient
     * @param amount     The quantity of this ingredient as float.
     * @param optional   Is the ingredient optional?
     */
    public QuantityRecipeItem(Ingredient ingredient, float amount, boolean optional) {
        super(ingredient, amount, optional);
    }

    public QuantityRecipeItem(UUID id, Ingredient ingredient, float amount, boolean optional) {
        super(id, ingredient, amount, optional);
    }

    public String display() {
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

        // if there is multiple of the item
        if (this.quantity() > 1) {
            return stringQuantity + " " + this.ingredient().name() + "s";
        }

        // if there is less than 1
        if (this.quantity() < 1) {
            //checks to see if the first letter of the ingredient name is a vowel.
            char letter = (this.ingredient().name()).charAt(0);

            if ("AEIOUaeiou".indexOf(letter) != -1) {
                return stringQuantity + " of an " + this.ingredient().name();
            }
            return stringQuantity + " of a " + this.ingredient().name();
        }

        // if there is just 1 item
        return stringQuantity + " " + this.ingredient().name();
    }

    @Override
    public String serializeTypeCode() {
        return "q";
    }
}
