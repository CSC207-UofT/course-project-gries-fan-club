package Entities;

import java.util.List;
import java.util.Set;

public interface Recipe extends Entity {

    /**
     * Return the list of all items needed to make this recipe
     *
     * @return the list of Items needed to make this recipe
     **/
    List<RecipeItem> items();

    /**
     * Returns a list of items from this recipe that match the given optional
     * parameter.
     *
     * IE: Passing in false returns only the required items.
     *
     * @param optional Whether to return optional or required items.
     *
     * @return A list of items that match the optional parameter.
     */
    List<RecipeItem> items(boolean optional);

    /**
     * Return the name of this recipe
     *
     * @return the name of recipe
     **/
    String name();

    /**
     * Return a description of this recipe
     *
     * @return a description of this recipe
     **/
    String description();

    /**
     * Return the instructions to make this recipe
     *
     * @return the instructions to make this recipe
     **/
    List<String> instructions();

    /**
     * Gets all the tags from ingredients within this recipe.
     *
     * @return A set of tags used in this recipe.
     */
    Set<Tag> tags();
}
