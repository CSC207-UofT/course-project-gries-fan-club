package main.java.Matchers;

import main.java.Entities.ItemImpl;
import main.java.Entities.TagImpl;
import main.java.EntityInterfaces.Recipe;
import main.java.EntityInterfaces.Tag;
import main.java.EntityInterfaces.Item;
import main.java.Storages.RecipeStorage;
import java.util.List;

/**
 * Match recipes based on tags
 */
public class TagMatcher implements MatcherImpl {
    List<TagImpl> tags;

    public TagMatcher(List<TagImpl> tags) {
        this.tags = tags;
    }

    @Override
    /**
     * Checks if item/ingredient contains any of the tags in the matcher
     */
    public Boolean matches(Recipe recipe) {
        for (Tag tag: this.tags) {
            boolean matchedTag = false;
            for (Item item : recipe.items()) {
                if (item.ingredient().has(tag)) {
                    matchedTag = true;
                }
            }
            if (!matchedTag) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean allMatches(RecipeStorage storage) {
        return null;
    }

}
