package Matchers;
import Entities.Recipe;
import Storages.RecipeStorageImpl;

// Matches ingredients with recipes
public interface Matcher {
    boolean matches(Recipe recipe);
    boolean allMatches(RecipeStorageImpl storage);
}
