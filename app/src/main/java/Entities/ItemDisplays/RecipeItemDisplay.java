package Entities.ItemDisplays;

import Entities.Ingredient;

public interface RecipeItemDisplay {
    /**
     * Returns display information for each respective recipe item type and quantity
     * @param quantity: float representing quantity
     * @param ingredient: ingredient that the recipeItem is
     * @return String representing display
     */
    String display(float quantity, Ingredient ingredient);

    /**
     * Return serialized type for RecipeItem
     */
    String serializeTypeCode();
}
