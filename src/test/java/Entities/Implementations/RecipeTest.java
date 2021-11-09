package Entities.Implementations;

import Entities.RecipeItem;
import Entities.Ingredient;
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
        this.recipe = new RecipeImpl("name", "description", Collections.singletonList("instructions"), Collections.emptyList());
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
        Assertions.assertEquals("instructions", recipe.instructions().get(0));
    }

    @Test
    public void testItems() {
        Ingredient ingredient1 = new IngredientImpl("apple", Collections.emptyList());
        QuantityRecipeItem item1 = new QuantityRecipeItem(ingredient1, 15f, false);

        Ingredient ingredient2 = new IngredientImpl("cucumber", Collections.emptyList());
        QuantityRecipeItem item2 = new QuantityRecipeItem(ingredient2, 1f, false);


        List<RecipeItem> recipeItems = new ArrayList<>();
        recipeItems.add((RecipeItem) item1);
        recipeItems.add((RecipeItem) item2);

        RecipeImpl recipe = new RecipeImpl("name", "description", Collections.singletonList("instructions"), recipeItems);

        Assertions.assertEquals(recipeItems, recipe.items());
        Assertions.assertEquals(recipeItems.size(), recipe.items().size());
    }


}
