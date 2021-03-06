package Entities.ItemDisplays;

import Entities.Ingredient;

public interface RecipeItemDisplay {
    /**
     * Returns display information for each respective recipe item type and quantity
     * @param quantity: Double representing quantity
     * @param ingredient: ingredient that the recipeItem is
     * @return String representing display
     */
    String display(double quantity, Ingredient ingredient);

    /**
     * Return serialized type for RecipeItem
     */
    String serializeTypeCode();
}
