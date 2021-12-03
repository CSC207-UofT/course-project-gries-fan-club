package Scorers;

import Entities.Recipe;
import Storages.RecipeStorage;
import java.util.List;

public interface Scorer {
    /**
     * Returns a match score based on the composite score of a number of matchers.
     * Currently, only score for TagMatcher and NameMatcher
     * @return match score
     */
    double score();

    /**
     * Returns top (num) recipes according to ingredientMatcher.
     * @param num is the number of recipes
     * @param recipes is the list of recipes to use
     * @return list of (num) recipes
     */
    List<Recipe> returnNumRecipes(RecipeStorage recipes, int num);

}
