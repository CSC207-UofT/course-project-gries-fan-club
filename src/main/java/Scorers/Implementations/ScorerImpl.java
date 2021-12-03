package Scorers.Implementations;

import Entities.Ingredient;
import Entities.Recipe;
import Entities.Tag;
import Matchers.Implementations.IngredientMatcher;
import Matchers.Implementations.TagMatcher;
import Scorers.Scorer;
import Storages.RecipeStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Double;

public class ScorerImpl implements Scorer {

    final List<Ingredient> ingredients;
    final List<Tag> tags;
    final String name;
    Recipe recipe;

    final IngredientMatcher ingredientMatcher;
    final TagMatcher tagMatcher;

    public ScorerImpl(List<Ingredient> ingredients, List<Tag> tags, String name) {
        this.ingredients = ingredients;
        this.tags = tags;
        this.name = name;
        this.ingredientMatcher = new IngredientMatcher(ingredients);
        this.tagMatcher = new TagMatcher(tags);
    }

    public double score() {
        //private final double NAME_VAL = 0.7; to be used in future updates
        double INGREDIENT_VAL = 0.7;
        double ingredientScore = INGREDIENT_VAL * this.ingredientMatcher.floatMatch(this.recipe);
        double TAG_VAL = 0.3;
        double tagScore = TAG_VAL * this.tagMatcher.floatMatch(this.recipe);
        return ingredientScore + tagScore;
    }

    /**
     * Take in a recipe storage and return a list of the top 10 (less if there isn't 10) most similar recipes
     * @param recipes list of recipes
     * @param num number of recipes to return
     * precondition: num <= recipes.size()
     */
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
