package Entities.Implementations;

import Entities.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IngredientTest {
    /**
     * Test the name of the ingredient class, that name is correctly returned
     */
    @Test
    public void testName() {
        IngredientImpl ingredient = new IngredientImpl("my name", Collections.emptyList());
        Assertions.assertEquals("my name", ingredient.name());
    }

    /**
     * Test whether the ingredient correctly takes in the list containing tags
     * Specifically, if the size of the list is the same as the one given in the constructor
     */
    @Test
    public void testTagsEmpty() {
        IngredientImpl ingredient = new IngredientImpl("", Collections.emptyList());
        Assertions.assertEquals(0, ingredient.tags().size());
    }

    /**
     * Test whether the ingredient correctly takes in the list containing tags
     * Specifically, if the list is exactly as was given into the constructor
     */
    @Test
    public void testTagsValues() {
        TagImpl tag1 = new TagImpl("Dairy");
        TagImpl tag2 = new TagImpl("Gluten");

        List<Tag> list = new ArrayList<>();
        list.add(tag1);
        list.add(tag2);

        IngredientImpl ingredient = new IngredientImpl("name", list); // ingredient containing tags now

        Assertions.assertEquals(list, ingredient.tags());

    }


    /**
     * Makes sure the ingredient has the correct tags.
     */
    @Test
    public void testHasTag() {
        TagImpl tag1 = new TagImpl("Dairy");
        TagImpl tag2 = new TagImpl("Gluten");
        TagImpl tag3 = new TagImpl("Sugar");

        List<Tag> list = new ArrayList<>();
        list.add(tag1);
        list.add(tag2);

        // ingredient contains tags added now
        IngredientImpl ingredient = new IngredientImpl("name", list);

        Assertions.assertTrue(ingredient.has(tag1));
        Assertions.assertFalse(ingredient.has(tag3));
    }

    @Test
    public void testToString() {
        TagImpl tag1 = new TagImpl("Dairy");
        TagImpl tag2 = new TagImpl("Gluten");
        TagImpl tag3 = new TagImpl("Sugar");

        List<Tag> list = new ArrayList<>();
        list.add(tag1);
        list.add(tag2);
        list.add(tag3);

        // ingredient contains tags added now
        IngredientImpl ingredient = new IngredientImpl("cake", list);

        Assertions.assertEquals(ingredient.toString(), """
                Ingredient {
                \tname='cake',
                \ttags=[Dairy, Gluten, Sugar]
                }""");
    }
}
