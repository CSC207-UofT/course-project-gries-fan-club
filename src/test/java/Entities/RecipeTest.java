package test.java.Entities;
import main.java.Entities.Recipe;
import main.java.Entities.Item;
import main.java.Entities.Ingredient;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RecipeTest {
     static Recipe recipe;

    @BeforeClass
    public static void setup() {
        recipe = new Recipe("name", "description", "instructions", Collections.emptyList());
    }

    @Test
    public void testName() {
        assertEquals("name", recipe.name());
    }

    @Test
    public void testDescription() {
        assertEquals("description", recipe.description());
    }

    @Test
    public void testInstructions() {
        assertEquals("instructions", recipe.instructions());
    }

    @Test
    public void testItems() {
        Ingredient ingredient1 = new Ingredient("apple", Collections.emptyList());
        Item item1 = new Item(ingredient1, 15);

        Ingredient ingredient2 = new Ingredient("cucumber", Collections.emptyList());
        Item item2 = new Item(ingredient2, 1);


        List<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);

        Recipe recipe = new Recipe("name", "description", "instructions", items);

        assertEquals(items, recipe.items());
        assertEquals(items.size(), recipe.items().size());
    }


}
