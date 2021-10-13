package main.java.Matchers;
import main.java.Entities.Recipe;
import main.java.Storages.RecipeStorage;

// Matches ingredients with recipes
public interface MatcherImpl {
    Boolean matches(Recipe recipe);
    Boolean allMatches(RecipeStorage storage);
}
