package Entities;

public interface RecipeItem {
    /**
     * Return the ingredient of the RecipeItem
     *
     * @return the ingredient object
     **/
    Ingredient ingredient();

    /**
     * Return the quantity of the Ingredient
     *
     * @return int representing the quantity
     **/
    int quantity();

    /**
     * Whether this item is optional in its recipe
     *
     * @return boolean representing if RecipeItem is optional
     **/
    boolean optional();
}
