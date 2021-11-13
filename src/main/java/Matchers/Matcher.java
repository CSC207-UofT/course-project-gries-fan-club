package Matchers;
import Entities.Recipe;

import java.util.List;

public interface Matcher {
    /** Returns whether or not the specified entity contains all of the tags.
     *
     * @param recipe
     * @return whether or not the entity has all the tags..
     */
    boolean matches(Recipe recipe);

    /**
     * Return the match percentage between a criterion and the recipe in [0, 1]
     * @param recipe
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
