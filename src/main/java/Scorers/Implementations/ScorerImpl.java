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

    IngredientMatcher ingredientMatcher;
    List<Ingredient> ingredients;

    public ScorerImpl(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        this.ingredientMatcher = new IngredientMatcher(this.ingredients);
    }

    @Override
    public double score() { //candidate for removal
        return 0;
    }

    @Override
    public List<Recipe> returnNumRecipes(List<Recipe> recipes, int num) {
        num = Math.min(num, recipes.size());
        recipes.sort(this::compareTo);
        return recipes.subList(recipes.size() - num, recipes.size());
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
