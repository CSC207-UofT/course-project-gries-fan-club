package Matchers.Implementations;

import Entities.Recipe;
import java.lang.Object;

public class NameMatcher extends AbstractMatcher {
    final String name;

    public NameMatcher(String name) { this.name = name; }

    public matches(Recipe recipe) { return recipe.name() == name; }

    /**
     * Use Levenshtein distance to compute difference in strings
     */
    public floatMatch(Recipe recipe) {
        int levDist = StringUtils.getLevenshteinDistance(recipe.name(), name);
        double percentMatch = (double) levDist/recipe.name();
        return 1.0 - percentMatch;
    }
}