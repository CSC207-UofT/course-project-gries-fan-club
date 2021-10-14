package test.java.Entities;
import main.java.Entities.RecipeImpl;
import main.java.Entities.ItemImpl;
import main.java.Entities.IngredientImpl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RecipeTest {
     static RecipeImpl recipe;

    @BeforeClass
    public static void setup() {
        recipe = new RecipeImpl("name", "description", "instructions", Collections.emptyList());
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
        IngredientImpl ingredient1 = new IngredientImpl("apple", Collections.emptyList());
        ItemImpl item1 = new ItemImpl(ingredient1, 15);

        IngredientImpl ingredient2 = new IngredientImpl("cucumber", Collections.emptyList());
        ItemImpl item2 = new ItemImpl(ingredient2, 1);


        List<ItemImpl> items = new ArrayList<ItemImpl>();
        items.add(item1);
        items.add(item2);

        RecipeImpl recipe = new RecipeImpl("name", "description", "instructions", items);

        assertEquals(items, recipe.items());
        assertEquals(items.size(), recipe.items().size());
    }


}
