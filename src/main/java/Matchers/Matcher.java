package Matchers;
import Entities.Entity;
import Entities.Recipe;
import Storages.Implementations.RecipeStorageImpl;

import java.util.ArrayList;
import java.util.List;

// Matches ingredients with recipes
public abstract class Matcher {
    /** Returns whether or not the specified entity contains all of the tags.
     *
     * @param recipe
     * @return whether or not the entity has all the tags..
     */
    public abstract boolean matches(Recipe recipe);

    /**
     * Returns list of recipes for which you have ingredients
     * @param recipes is a list of recipes
     * @return list of recipes for which ingredients are had
     */
    public List<Recipe> allMatches(List<Recipe> recipes) {
        List<Recipe> matchedRecipes = new ArrayList<>();
        for (Recipe recipe : recipes)
            if (matches(recipe))
                matchedRecipes.add(recipe);
        return matchedRecipes;
    }
}
