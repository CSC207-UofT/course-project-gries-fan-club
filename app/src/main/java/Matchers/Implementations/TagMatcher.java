package Matchers.Implementations;

import Entities.Recipe;
import Entities.Tag;

import java.util.List;
import java.util.Set;

/**
 * Match recipes based on tags
 */
public class TagMatcher extends AbstractMatcher {
    final List<Tag> tags;

    public TagMatcher (List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Checks if item/ingredient contains any of the tags in the matcher/
     * returns TRUE if the recipe contains one of the specified tags.
     */
    @Override
    public boolean matches(Recipe recipe) {
        Set<Tag> recipeTags = recipe.tags();

        for (Tag tag : this.tags) {
            if (!recipeTags.contains(tag)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the percentage of specified tags that a recipe has.
     */
    @Override
    public double floatMatch(Recipe recipe) {
        Set<Tag> recipeTags = recipe.tags();
        int counter = 0;

        for (Tag tag : this.tags) {
            if (recipeTags.contains(tag)) {
                counter++;
            }
        }

        return (double) counter / this.tags.size();
    }

}
