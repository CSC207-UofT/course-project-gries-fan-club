package Matcher;

import Entities.IngredientImpl;
import Entities.ItemImpl;
import Entities.RecipeImpl;
import Entities.TagImpl;
import EntityInterfaces.Item;
import EntityInterfaces.Tag;
import Matchers.TagMatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TagMatcherTest {

    /**
     * Defines the setup for easier testing
     */

    @Test
    public void testMatchesTrue() {
        // Tag list
        TagImpl tag1 = new TagImpl("Dairy");
        TagImpl tag2 = new TagImpl("Gluten");

        List<Tag> tags = new ArrayList<>();
        tags.add(tag1);

        List<Tag> list = new ArrayList<>();
        list.add(tag1);
        list.add(tag2);

        // Recipe
        IngredientImpl ingredient1 = new IngredientImpl("bread", list);
        ItemImpl item = new ItemImpl(ingredient1, 15);
        List<Item> items = new ArrayList<>();
        items.add(item);
        RecipeImpl recipe = new RecipeImpl("name", "description", "instructions", items);

        // Matcher
        TagMatcher matcher = new TagMatcher(tags);
        Assertions.assertTrue(matcher.matches(recipe));
    }

    @Test
    public void testMatchesFalse() {
        // Tag list
        TagImpl tag1 = new TagImpl("Dairy");
        TagImpl tag2 = new TagImpl("Gluten");

        List<Tag> tags = new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);

        List<Tag> list = new ArrayList<>();
        list.add(tag1);

        // Recipe
        IngredientImpl ingredient1 = new IngredientImpl("bread", list);
        ItemImpl item = new ItemImpl(ingredient1, 15);
        List<Item> items = new ArrayList<>();
        items.add(item);
        RecipeImpl recipe = new RecipeImpl("name", "description", "instructions", items);

        // Matcher
        TagMatcher matcher = new TagMatcher(tags);
        Assertions.assertFalse(matcher.matches(recipe));
    }
}
