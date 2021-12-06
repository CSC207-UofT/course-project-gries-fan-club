package Matchers;
import Entities.Recipe;

import java.util.List;

public interface Matcher {
    /** Returns whether the specified entity contains all the tags.
     *
     * @param recipe the recipe we are checking
     * @return whether the entity has all the tags.
     */
    double matches(Recipe recipe);
}
