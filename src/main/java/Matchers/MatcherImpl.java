package Matchers;
import EntityInterfaces.Recipe;
import Storages.RecipeStorage;

// Matches ingredients with recipes
public interface MatcherImpl {
    Boolean matches(Recipe recipe);
    Boolean allMatches(RecipeStorage storage);
}
