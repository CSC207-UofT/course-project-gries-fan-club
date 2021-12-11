package Matchers.Implementations;
import Entities.Recipe;
import Matchers.Matcher;

import java.util.ArrayList;
import java.util.List;


// Matches ingredients with recipes
public abstract class AbstractMatcher implements Matcher {

    @Override
    public abstract boolean matches(Recipe recipe);

    @Override
    public List<Recipe> allMatches(List<Recipe> recipes) {
        List<Recipe> matchedRecipes = new ArrayList<>();
        for (Recipe recipe : recipes)
            if (matches(recipe))
                matchedRecipes.add(recipe);
        return matchedRecipes;
    }

    @Override
    public abstract double floatMatch (Recipe recipe);
}
