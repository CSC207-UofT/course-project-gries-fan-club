package Matchers;
import Entities.Recipe;

import java.util.List;

public interface Matcher {
    /** Returns whether the specified entity contains all the tags.
     *
     * @param recipe the recipe we are checking
     * @return whether the entity has all the tags.
     */
    boolean matches(Recipe recipe);

    /**
     * Return the match percentage between a criterion and the recipe in [0, 1]
     * @param recipe the recipe we are checking
     * @return Match percentage as double
     */
    double floatMatch (Recipe recipe);

    /**
     * Returns list of recipes for which you have ingredients
     * @param recipes is a list of recipes
     * @return list of recipes for which ingredients are had
     */
    List<Recipe> allMatches(List<Recipe> recipes);
}
