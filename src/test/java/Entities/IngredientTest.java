package test.java.Entities;

import main.java.Entities.Ingredient;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testName() {
        Ingredient ingredient = new Ingredient("my name", Collections.emptyList());

        assertEquals("my name", ingredient.name());
    }

    @Test
    public void testTags() {
        Ingredient ingredient = new Ingredient("", Collections.emptyList());

        assertEquals(0, ingredient.tags().size());
    }

}
