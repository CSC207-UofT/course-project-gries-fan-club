package EntityInterfaces;

import java.util.List;

public interface Recipe {

    /**
     * List of Items required for this recipe
     **/
    List<Item> items();

    /**
     *  Name of recipe
     **/
    String name();

    /**
     * Description of recipe
     **/
    String description();

    /**
     * Instructions to make Recipe
     **/
    String instructions();
}
