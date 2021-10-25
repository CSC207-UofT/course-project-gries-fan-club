package Entities;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.RecipeImpl;
import Entities.Implementations.RecipeItemImpl;
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
        RecipeItemImpl item1 = new RecipeItemImpl(ingredient1, 15);

        IngredientImpl ingredient2 = new IngredientImpl("cucumber", Collections.emptyList());
        RecipeItemImpl item2 = new RecipeItemImpl(ingredient2, 1);


        List<RecipeItem> recipeItems = new ArrayList<>();
        recipeItems.add(item1);
        recipeItems.add(item2);

        RecipeImpl recipe = new RecipeImpl("name", "description", "instructions", recipeItems);

        Assertions.assertEquals(recipeItems, recipe.items());
        Assertions.assertEquals(recipeItems.size(), recipe.items().size());
    }


}
