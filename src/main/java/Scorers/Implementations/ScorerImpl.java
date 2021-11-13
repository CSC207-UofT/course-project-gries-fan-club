package Scorers.Implementations;

import Entities.Ingredient;
import Entities.Recipe;
import Entities.Tag;
import Matchers.Implementations.IngredientMatcher;
import Matchers.Implementations.TagMatcher;
import Scorers.Scorer;

import java.util.List;

public class ScorerImpl implements Scorer {

    List<Ingredient> ingredients;
    List<Tag> tags;
    String name;
    Recipe recipe;

    IngredientMatcher ingredientMatcher;
    TagMatcher tagMatcher;

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
}
