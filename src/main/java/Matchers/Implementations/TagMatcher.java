package Matchers.Implementations;

import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Tag;
import Matchers.Matcher;
import Matchers.QuantifiableMatch;
import Storages.Implementations.RecipeStorageImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Match recipes based on tags
 */
public class TagMatcher extends Matcher implements QuantifiableMatch {
    List<Tag> tags;

    public TagMatcher (List<Tag> tags) { this.tags = tags; }

    /**
     * Checks if item/ingredient contains any of the tags in the matcher/
     * returns TRUE if the recipe contains one of the specified tags.
     */
    @Override
    public boolean matches(Recipe recipe) {
        List<Tag> recipeTags = recipe.tags();
        for (Tag tag: this.tags)
            if (recipeTags.contains(tag))
                    return true;
        return false;
    }

    /**
     * Returns the percentage of specified tags that a recipe has.
     */
    @Override
    public double floatMatch(Recipe recipe) {
        List<Tag> recipeTags = recipe.tags();
        int counter = 0;
        for (Tag tag : this.tags)
            if (recipeTags.contains(tag))
                counter++;
        return (double) counter / this.tags.size();
    }

}
