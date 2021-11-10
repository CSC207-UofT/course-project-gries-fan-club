package Scorers.Implementations;
import Entities.Ingredient;
import Entities.Tag;
import Entities.Recipe;
import Matchers.Implementations.IngredientMatcher;
import Matchers.Implementations.NameMatcher;
import Matchers.Implementations.TagMatcher;
import Scorers.Scorer;
import java.util.ArrayList;
import java.util.List;

public class ScorerImpl implements Scorer {
    private final double NAME_VAL = 0.7;
    private final double INGREDIENT_VAL = 0.15;
    private final double TAG_VAL = 0.15;

    List<Ingredient> ingredients;
    List<Tag> tags;
    String name;
    Recipe recipe;

    IngredientMatcher ingredientMatcher;
    TagMatcher tagMatcher;
    NameMatcher nameMatcher;

    public ScorerImpl(List<Ingredient> ingredients, List<Tag> tags, String name) {
        this.ingredients = ingredients;
        this.tags = tags;
        this.name = name;
        this.ingredientMatcher = new IngredientMatcher(ingredients);
        this.tagMatcher = new TagMatcher(tags);
        this.nameMatcher = new NameMatcher(name);
    }

    public double score() {
        double ingredientScore = this.INGREDIENT_VAL * this.ingredientMatcher.floatMatch(this.recipe);
        double nameScore = this.NAME_VAL * this.nameMatcher.floatMatch(this.recipe);
        double tagScore = this.TAG_VAL * this.tagMatcher.floatMatch(this.recipe);
        return ingredientScore + nameScore + tagScore;
    }
}
