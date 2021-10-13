package main.java.Matchers;

import main.java.EntityInterfaces.RecipeImpl;
import main.java.Entities.Tag;
import main.java.Storages.RecipeStorage;
import main.java.Entities.Recipe;
import main.java.Entities.Item;



import java.util.List;

/**
 * Match recipes based on tags
 */
public class TagMatcher implements MatcherImpl {
    List<Tag> tags;

    public TagMatcher(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    /**
     * Checks if item/ingredient contains any of the tags in the matcher
     */
    public Boolean matches(Recipe recipe) {
        for (Tag tag: this.tags) {
            for (Item item : recipe.items()) {
                if (item.ingredient().has(tag)) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public Boolean allMatches(RecipeStorage storage) {
        return null;
    }

}
