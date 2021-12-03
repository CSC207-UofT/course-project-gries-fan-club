package Scorers.Implementations;

import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Tag;
import Matchers.Implementations.IngredientMatcher;
import Matchers.Implementations.TagMatcher;
import Scorers.Scorer;
import Storages.RecipeStorage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ScorerImpl implements Scorer {

    final IngredientMatcher ingredientMatcher;

    public ScorerImpl(List<Recipe> recipes) {
        List<Ingredient> ingredientList = new ArrayList<>();
        for (Recipe recipe : recipes)
            for (RecipeItem recipeItem : recipe.items())
                ingredientList.add(recipeItem.ingredient());
        ingredientList = new ArrayList<> (new HashSet<>(ingredientList));
        this.ingredientMatcher = new IngredientMatcher(ingredientList);
    }

    @Override
    public double score() { //candidate for removal
        return 0;
    }

    @Override
    public List<Recipe> returnNumRecipes(RecipeStorage recipes, int num) {
        num = Math.min(num, recipes.size());
        List<Recipe> allRecipes = new ArrayList<>(recipes.recipes());
        allRecipes.sort(this::compareTo);
        return allRecipes.subList(allRecipes.size() - num, allRecipes.size());
    }

    /**
     * For use as a private helper method to be a comparator for the lambda sorting in returnNumRecipes
     * @param r1 is a recipe
     * @param r2 is another recipe
     * @return integer denoting whether one math is greater than the other or if they're equal
     */
    private int compareTo(Recipe r1, Recipe r2) {
        if (this.ingredientMatcher.floatMatch(r1) > this.ingredientMatcher.floatMatch(r2))
            return 1;
        else if (this.ingredientMatcher.floatMatch(r1) == this.ingredientMatcher.floatMatch(r2))
            return 0;
        return -1;
    }
}
