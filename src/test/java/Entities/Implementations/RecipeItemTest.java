package Entities.Implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class RecipeItemTest {

    @Test
    public void testQuantity() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        int quantity = 15;
        RecipeItemImpl item = new RecipeItemImpl(ingredient, quantity);

        Assertions.assertEquals(15, item.quantity());

    }

    @Test
    public void testOptional() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        int quantity = 15;
        RecipeItemImpl item = new RecipeItemImpl(ingredient, quantity, true);

        Assertions.assertTrue(item.optional());
    }

    @Test
    public void testIngredient() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        int quantity = 15;
        RecipeItemImpl item = new RecipeItemImpl(ingredient, quantity);

        Assertions.assertEquals(ingredient, item.ingredient());
    }

}
