package Matchers.Implementations;

import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Tag;
import Matchers.Matcher;

import java.util.ArrayList;
import java.util.List;

public class IngredientMatcher implements Matcher<Recipe> {

    List<Ingredient> ingredients;

    public IngredientMatcher (List<Ingredient> ingredients) { this.ingredients = ingredients; }

    /**
     * Checks if a list of ingredients contains all of the ingredients that a recipe needs
     * @param recipe is the recipe to check
     * @return whether or not the recipe has all of the required ingredients
     */
    @Override
    public boolean matches(Recipe recipe) {
        List<RecipeItem> recipeItems = recipe.items();
        for (RecipeItem recipeItem : recipeItems)
            if (!this.ingredients.contains(recipeItem.ingredient()))
                return false;
        return true;
    }

    /**
     * Returns the percentage of ingredients that you have compared to a recipe
     * @param recipe is the recipe to check
     * @return percentage of ingredients had
     */
    @Override
    public double floatMatch(Recipe recipe) {
        List<RecipeItem> recipeItems = recipe.items();
        int counter = 0;
        for (RecipeItem recipeItem : recipeItems)
            if (this.ingredients.contains(recipeItem.ingredient()))
                counter++;
        return (double) counter/recipeItems.size();
    }

    /**
     * Returns list of recipes for which you have ingredients
     * @param recipes is a list of recipes
     * @return list of recipes for which ingredients are had
     */
    @Override
    public List<Recipe> allMatches(List<Recipe> recipes) {
        List<Recipe> matchedRecipes = new ArrayList<>();
        for (Recipe recipe : recipes)
            if (matches(recipe))
                matchedRecipes.add(recipe);
        return matchedRecipes;
    }
}
