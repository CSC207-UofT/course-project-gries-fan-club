package Scorers.Implementations;

import Entities.Ingredient;
import Entities.Recipe;
import Entities.Tag;
import Matchers.Implementations.IngredientMatcher;
import Matchers.Implementations.TagMatcher;
import Matchers.Implementations.NameMatcher;
import Scorers.Scorer;

import java.util.List;

public class ScorerImpl implements Scorer {

    final List<Ingredient> ingredients;
    final List<Tag> tags;
    final String name;
    Recipe recipe;

    final IngredientMatcher ingredientMatcher;
    final TagMatcher tagMatcher;
    final NameMatcher nameMatcher;

    public ScorerImpl(List<Ingredient> ingredients, List<Tag> tags, String name) {
        this.ingredients = ingredients;
        this.tags = tags;
        this.name = name;
        this.ingredientMatcher = new IngredientMatcher(ingredients);
        this.tagMatcher = new TagMatcher(tags);
        this.nameMatcher = new NameMatcher(name);
    }

    public double score(Recipe recipe) {
        if (!tagMatcher.matches(recipe))
            return 0;
        return nameMatcher(recipe) * 0.7 + tagMatcher(recipe) * 0.3;
    }
}
