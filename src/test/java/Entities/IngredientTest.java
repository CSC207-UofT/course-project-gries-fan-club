package Entities;
import EntityInterfaces.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class IngredientTest {

    @Test
    public void testName() {
        IngredientImpl ingredient = new IngredientImpl("my name", Collections.emptyList());
        Assertions.assertEquals("my name", ingredient.name());
    }

    @Test
    public void testTagsEmpty() {
        IngredientImpl ingredient = new IngredientImpl("", Collections.emptyList());
        Assertions.assertEquals(0, ingredient.tags().size());
    }

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

    /**
     * Tests the inheritance of ingredient from the abstract entity class
     * Specifically, testing whether or not ingredient is able to take a random id and successfully
     * return it
     */
    @Test
    public void testInheritance() {
        UUID randomID = UUID.randomUUID();
        IngredientImpl ingredient = new IngredientImpl(randomID, "name", Collections.emptyList());
        Assertions.assertEquals(randomID, ingredient.id());
    }
}
