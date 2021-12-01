package Entities.Implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class RecipeItemTest {

    @Test
    public void testQuantity() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        float quantity = 15f;
        QuantityRecipeItem item = new QuantityRecipeItem(ingredient, quantity, false);

        Assertions.assertEquals(15, item.quantity());

    }

    @Test
    public void testOptional() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        float quantity = 15f;
        QuantityRecipeItem item = new QuantityRecipeItem(ingredient, quantity, true);

        Assertions.assertTrue(item.optional());
    }

    @Test
    public void testIngredient() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        float quantity = 15f;
        QuantityRecipeItem item = new QuantityRecipeItem(ingredient, quantity, true);

        Assertions.assertEquals(ingredient, item.ingredient());
    }

}
