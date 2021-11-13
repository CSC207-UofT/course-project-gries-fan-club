package Matchers;
import Entities.Recipe;
import Storages.Implementations.RecipeStorageImpl;

import java.util.List;

// Matches ingredients with recipes
public interface Matcher {
    boolean matches(Recipe recipe);
    List<Recipe> allMatches(RecipeStorageImpl storage);
}
