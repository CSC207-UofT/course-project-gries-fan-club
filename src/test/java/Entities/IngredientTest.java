package test.java.Entities;

import main.java.Entities.Ingredient;
import main.java.Entities.Tag;
import main.java.EntityInterfaces.TagImpl;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testName() {
        Ingredient ingredient = new Ingredient("my name", Collections.emptyList());
        assertEquals("my name", ingredient.name());
    }

    @Test
    public void testTagsEmpty() {
        Ingredient ingredient1 = new Ingredient("", Collections.emptyList());
        assertEquals(0, ingredient1.tags().size());
    }
    @Test
    public void testTagsValues() {
        Tag tag1 = new Tag("Dairy");
        Tag tag2 = new Tag("Gluten");

        List<Tag> list = new ArrayList<Tag>();
        list.add(tag1);
        list.add(tag2);

        Ingredient ingredient = new Ingredient("name", list); // ingredient containing tags now

        assertEquals(list, ingredient.tags());

    }

    @Test
    public void testHasTag() {
        Tag tag1 = new Tag("Dairy");
        Tag tag2 = new Tag("Gluten");

        List<Tag> list = new ArrayList<Tag>();
        list.add(tag1);
        list.add(tag2);

        Ingredient ingredient2 = new Ingredient("name", list); // ingredient containing tags now

        assertEquals(true, ingredient2.has(tag1));


    }

}
