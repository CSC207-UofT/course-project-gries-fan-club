package Entities.Implementations;

import Entities.Implementations.AbstractRecipeItem;
import Entities.Ingredient;

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

    public String display(){

        String stringquantity = Float.toString(this.quantity());
        return stringquantity + "ml of" + this.ingredient();
    }

}
