package Entities;

public interface RecipeItem extends Entity {
    /**
     * Return the ingredient of the RecipeItem
     *
     * @return the ingredient object
     */
    Ingredient ingredient();

    /**
     * Return the quantity of the Ingredient
     *
     * @return int representing the quantity
     */
    float quantity();

    /**
     * Whether this item is optional in its recipe
     *
     * @return boolean representing if RecipeItem is optional
     */
    boolean optional();

    /**
     * A string representing this RecipeItem.
     *
     * @return A string containing information on this item.
     */
    String display();

    /**
     * Returns a string that is used within serialization to denote the subtype
     * of this recipe item.
     *
     * @return The code for serialization.
     */
    String serializeTypeCode();
}
