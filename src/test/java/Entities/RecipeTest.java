package Entities;

import EntityInterfaces.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RecipeTest {
    RecipeImpl recipe;

    @BeforeEach
    public  void setup() {
        this.recipe = new RecipeImpl("name", "description", "instructions", Collections.emptyList());
    }

    @Test
    public void testName() {
        Assertions.assertEquals("name", recipe.name());
    }

    @Test
    public void testDescription() {
        Assertions.assertEquals("description", recipe.description());
    }

    @Test
    public void testInstructions() {
        Assertions.assertEquals("instructions", recipe.instructions());
    }

    @Test
    public void testItems() {
        IngredientImpl ingredient1 = new IngredientImpl("apple", Collections.emptyList());
        ItemImpl item1 = new ItemImpl(ingredient1, 15);

        IngredientImpl ingredient2 = new IngredientImpl("cucumber", Collections.emptyList());
        ItemImpl item2 = new ItemImpl(ingredient2, 1);


        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        RecipeImpl recipe = new RecipeImpl("name", "description", "instructions", items);

        Assertions.assertEquals(items, recipe.items());
        Assertions.assertEquals(items.size(), recipe.items().size());
    }


}
