package Matchers;

import EntityInterfaces.Item;
import EntityInterfaces.Recipe;
import EntityInterfaces.Tag;
import Storages.RecipeStorage;

import java.util.List;

/**
 * Match recipes based on tags
 */
public class TagMatcher implements Matcher {
    List<Tag> tags;

    /**
     * Checks if item/ingredient contains any of the tags in the matcher
     */
    @Override
    public boolean matches(Recipe recipe) {
        for (Tag tag: this.tags) {
            boolean matchedTag = false;
            for (Item item : recipe.items()) {
                if (item.ingredient().has(tag)) {
                    matchedTag = true;
                    break;
                }
            }
            if (!matchedTag) {
                return false;
            }
        }
        return true;
    }

    public TagMatcher(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean allMatches(RecipeStorage storage) {
        return true;
    }

}
