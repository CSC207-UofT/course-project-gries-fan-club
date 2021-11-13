package Matchers.Implementations;

import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;

import java.util.List;

public class IngredientMatcher extends AbstractMatcher {

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
}
