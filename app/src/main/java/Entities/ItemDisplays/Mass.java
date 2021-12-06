package Entities.ItemDisplays;

import Entities.Ingredient;

public class Mass implements RecipeItemDisplay {
    /**
     * Represent the mass item
     * @return
     */
    @Override
    public String display(float quantity, Ingredient ingredient) {
        String stringQuantity;

        // checks if the quantity ends in .0 or .00 (whole number)
        if (quantity % 1 == 0) {
            // make it an int to remove the decimal
            stringQuantity = Integer.toString((int) quantity);
        } else {
            // Convert to a string for returning
            stringQuantity = Float.toString(quantity);
        }
        return stringQuantity + "g of " + ingredient.name();
    }

    @Override
    public String serializeTypeCode() {
        return "m";
    }
}
