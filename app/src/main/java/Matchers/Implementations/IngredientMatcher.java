package Matchers.Implementations;

import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Storages.RecipeStorage;

import java.util.ArrayList;
import java.util.List;

public class IngredientMatcher extends AbstractMatcher {

    final List<Ingredient> ingredients;

    public IngredientMatcher (List<Ingredient> ingredients) { this.ingredients = ingredients; }

    /**
     * Checks if a list of ingredients contains all the ingredients that a recipe needs
     * @param recipe is the recipe to check
     * @return whether the recipe has all the required ingredients
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
     * Take in a recipe storage and return a list of the top 10 (less if there isn't 10) most similar recipes
     * @param recipes list of recipes
     */
    public List<Recipe> returnRecipesMatched(RecipeStorage recipes, int numberOfRecipes) {
        List<Recipe> allRecipes = new ArrayList<>();

        for (Recipe recipe : recipes.recipes()) {
            // if it's less than numberOfRecipes, just add it
            if (allRecipes.size() < numberOfRecipes) {
                allRecipes.add(recipe);
            } else {
                // if more than numberOfRecipes, only put it if it has a higher floatMatch value
                for (Recipe value : allRecipes) {
                    if (this.floatMatch(recipe) < this.floatMatch(value)) {
                        // replace value
                        allRecipes.remove(value);
                        allRecipes.add(recipe);
                    }
                }
            }
        }
        return allRecipes;
    }
}
