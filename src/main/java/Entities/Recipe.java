package Entities;

import java.util.List;

public interface Recipe extends Entity {

    /**
     * Return the list of items needed to make this recipe
     *
     * @return the list of Items needed to make this recipe
     **/
    List<RecipeItem> items();

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
    String instructions();
}
