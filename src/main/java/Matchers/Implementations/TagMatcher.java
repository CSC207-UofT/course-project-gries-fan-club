package Matchers.Implementations;

import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Tag;
import Matchers.Matcher;
import Storages.Implementations.RecipeStorageImpl;

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
            for (RecipeItem recipeItem : recipe.items()) {
                if (recipeItem.ingredient().has(tag)) {
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
    public List<Recipe> allMatches(RecipeStorageImpl storage) {
        return null;
    }

}
