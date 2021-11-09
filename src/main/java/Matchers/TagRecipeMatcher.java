package Matchers;

import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Tag;
import Storages.Implementations.RecipeStorageImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Match recipes based on tags
 */
public class TagRecipeMatcher implements TagMatcher<Recipe> {
    List<Tag> tags;

    /**
     * Checks if item/ingredient contains any of the tags in the matcher
     */
    @Override
    public boolean binaryMatch(Recipe recipe) {
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

    public double floatMatch(Recipe recipe) {
        int counter = 0;
        ArrayList<String> usedTags = new ArrayList<>(); //no repeat tag entries
        for (Tag tag: this.tags) {
            for (RecipeItem recipeItem : recipe.items()) {
                if (recipeItem.ingredient().has(tag))
                    if (!usedTags.contains(tag.name())) {
                        counter++;
                        usedTags.add(tag.name());
                    }
                if (counter == this.tags.size())
                    break;
            }
        }
        return (double) counter/this.tags.size();
    }

    @Override
    public boolean allMatches(RecipeStorageImpl storage) {
        return true;
    }

}
