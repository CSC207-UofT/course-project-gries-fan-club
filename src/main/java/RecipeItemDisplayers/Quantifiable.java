package RecipeItemDisplayers;

import Entities.RecipeItemDisplay;
import Entities.Ingredient;

public class Quantifiable implements RecipeItemDisplay {

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

        // if there is multiple of the item
        if (quantity > 1) {
            return stringQuantity + " " + ingredient.name() + "s";
        }

        // if there is less than 1
        if (quantity < 1) {
            //checks to see if the first letter of the ingredient name is a vowel.
            char letter = (ingredient.name()).charAt(0);

            if ("AEIOUaeiou".indexOf(letter) != -1) {
                return stringQuantity + " of an " + ingredient.name();
            }
            return stringQuantity + " of a " + ingredient.name();
        }

        // if there is just 1 item
        return stringQuantity + " " + ingredient.name();
    }

    @Override
    public String serializeTypeCode() {
        return "q";
    }
}
