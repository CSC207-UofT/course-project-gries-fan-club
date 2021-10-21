package EntityInterfaces;

import Entities.Ingredient;

public interface RecipeItem {
    /**
     * The ingredient that this item is.
     *
     * @return The ingredient.
     */
    Ingredient ingredient();

    /**
     * The amount of ingredient needed.
     *
     * @return A float representing this quantity.
     */
    float quantity();

    /**
     * Whether this item is required for the recipe.
     *
     * @return Whether this is optional.
     */
    boolean optional();

    /**
     * forms a string of the ingredient with the amount needed for the recipe in either ml
     *      * or in quantity form.
     * @return the string of the ingredient with the amount needed for the recipe in either ml
     * or in quantity form.
     */
    String display();
}
