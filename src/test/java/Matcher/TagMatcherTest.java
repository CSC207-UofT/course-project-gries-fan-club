package test.java.Matcher;

//import main.java.Entities.Ingredient;
import main.java.Entities.Recipe;
import main.java.Matchers.TagMatcher;
import main.java.Entities.Ingredient;
import main.java.Entities.Item;
import main.java.Entities.Tag;

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
        Tag tag1 = new Tag("Dairy");
        Tag tag2 = new Tag("Gluten");

        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag1);
        tags.add(tag2);

        List<Tag> list = new ArrayList<Tag>();
        list.add(tag1);

        // Recipe
        Ingredient ingredient1 = new Ingredient("bread", list);
        Item item = new Item(ingredient1, 15);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        Recipe recipe = new Recipe("name", "description", "instructions", items);

        // Matcher
        TagMatcher matcher = new TagMatcher(tags);
        assertEquals(true, matcher.matches(recipe));
    }

    @Test
    public void testMatchesFalse() {
        // Tag list
        Tag tag1 = new Tag("Dairy");
        Tag tag2 = new Tag("Gluten");

        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag1);

        List<Tag> list = new ArrayList<Tag>();
        list.add(tag2);

        // Recipe
        Ingredient ingredient1 = new Ingredient("bread", list);
        Item item = new Item(ingredient1, 15);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        Recipe recipe = new Recipe("name", "description", "instructions", items);

        // Matcher
        TagMatcher matcher = new TagMatcher(tags);
        assertEquals(false, matcher.matches(recipe));
    }
}
