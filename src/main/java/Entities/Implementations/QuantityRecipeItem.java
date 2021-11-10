package Entities.Implementations;

import Entities.Implementations.AbstractRecipeItem;
import Entities.Ingredient;

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

    public String display() {
        String stringquantity = Float.toString(this.quantity());
        if (this.quantity() > 1) {

            return stringquantity + this.ingredient().name() + "s";
        }
        if (this.quantity() < 1) {
            //checks to see if the first letter of the ingredient name is a vowel.
            char letter = (this.ingredient().name()).charAt(0);

            if ("AEIOUaeiou".indexOf(letter) != -1) {
                return stringquantity + "of an" + this.ingredient().name();
            }
            return stringquantity + "of a" + this.ingredient().name();
        }
        return stringquantity + this.ingredient().name();
    }

}
