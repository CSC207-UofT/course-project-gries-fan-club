package Entities;

import EntityInterfaces.Ingredient;

public class VolumetricRecipeItem extends AbstractRecipeItem{

    /**
     * Implement a ItemImpl, giving the ingredient,
     * quantity of this ingredient, and if the ingredient is optional.
     *
     * @param ingredient The ingredient
     * @param amount     The quantity of this ingredient
     * @param optional   Is the ingredient optional?
     */
    public VolumetricRecipeItem(Ingredient ingredient, float amount, boolean optional) {
        super(ingredient, amount, optional);
    }

    public String display(){
        String stringquantity = Float.toString(this.quantity());
      return stringquantity + "ml of" + this.ingredient;
    }

}
