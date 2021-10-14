package test.java.Matcher;

import main.java.Entities.RecipeImpl;
import main.java.EntityInterfaces.Recipe;
import main.java.Matchers.TagMatcher;
import main.java.Entities.IngredientImpl;
import main.java.Entities.ItemImpl;
import main.java.Entities.TagImpl;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class TagMatcherTest {

    /**
     * Defines the setup for easier testing
     */

    @Test
    public void testMatchesTrue() {
        // Tag list
        TagImpl tag1 = new TagImpl("Dairy");
        TagImpl tag2 = new TagImpl("Gluten");

        List<TagImpl> tags = new ArrayList<TagImpl>();
        tags.add(tag1);

        List<TagImpl> list = new ArrayList<TagImpl>();
        list.add(tag1);
        tags.add(tag2);

        // Recipe
        IngredientImpl ingredient1 = new IngredientImpl("bread", list);
        ItemImpl item = new ItemImpl(ingredient1, 15);
        List<ItemImpl> items = new ArrayList<ItemImpl>();
        items.add(item);
        RecipeImpl recipe = new RecipeImpl("name", "description", "instructions", items);

        // Matcher
        TagMatcher matcher = new TagMatcher(tags);
        assertTrue(matcher.matches(recipe));
    }

    @Test
    public void testMatchesFalse() {
        // Tag list
        TagImpl tag1 = new TagImpl("Dairy");
        TagImpl tag2 = new TagImpl("Gluten");

        List<TagImpl> tags = new ArrayList<TagImpl>();
        tags.add(tag1);
        tags.add(tag2);

        List<TagImpl> list = new ArrayList<TagImpl>();
        list.add(tag1);

        // Recipe
        IngredientImpl ingredient1 = new IngredientImpl("bread", list);
        ItemImpl item = new ItemImpl(ingredient1, 15);
        List<ItemImpl> items = new ArrayList<ItemImpl>();
        items.add(item);
        RecipeImpl recipe = new RecipeImpl("name", "description", "instructions", items);

        // Matcher
        TagMatcher matcher = new TagMatcher(tags);
        assertFalse(matcher.matches(recipe));
    }
}
