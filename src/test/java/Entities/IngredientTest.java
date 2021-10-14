package test.java.Entities;

import main.java.Entities.IngredientImpl;
import main.java.Entities.TagImpl;
import main.java.EntityInterfaces.Tag;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testName() {
        IngredientImpl ingredient = new IngredientImpl("my name", Collections.emptyList());
        assertEquals("my name", ingredient.name());
    }

    @Test
    public void testTagsEmpty() {
        IngredientImpl ingredient = new IngredientImpl("", Collections.emptyList());
        assertEquals(0, ingredient.tags().size());
    }

    @Test
    public void testTagsValues() {
        TagImpl tag1 = new TagImpl("Dairy");
        TagImpl tag2 = new TagImpl("Gluten");

        List<TagImpl> list = new ArrayList<TagImpl>();
        list.add(tag1);
        list.add(tag2);

        IngredientImpl ingredient = new IngredientImpl("name", list); // ingredient containing tags now

        assertEquals(list, ingredient.tags());

    }

    @Test
    public void testHasTag() {
        TagImpl tag1 = new TagImpl("Dairy");
        TagImpl tag2 = new TagImpl("Gluten");
        TagImpl tag3 = new TagImpl("Sugar");

        List<TagImpl> list = new ArrayList<TagImpl>();
        list.add(tag1);
        list.add(tag2);

        // ingredient contains tags added now
        IngredientImpl ingredient = new IngredientImpl("name", list);

        assertTrue(ingredient.has(tag1));
        assertFalse(ingredient.has(tag3));


    }

}
