package Matchers;
import EntityInterfaces.Recipe;
import Storages.RecipeStorage;

// Matches ingredients with recipes
public interface Matcher {
    boolean matches(Recipe recipe);
    boolean allMatches(RecipeStorage storage);
}
