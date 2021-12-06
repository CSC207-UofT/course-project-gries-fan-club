package Entities.Implementations;

import Entities.ItemDisplays.Quantifiable;
import Entities.ItemDisplays.RecipeItemDisplay;
import Entities.RecipeItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class RecipeItemTest {

    @Test
    public void testQuantity() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        float quantity = 15f;
        RecipeItemDisplay quantifiable = new Quantifiable();
        RecipeItem item = new RecipeItemImpl(ingredient, quantity, false, quantifiable);

        Assertions.assertEquals(15, item.quantity());

    }

    @Test
    public void testOptional() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        float quantity = 15f;
        RecipeItemDisplay quantifiable = new Quantifiable();
        RecipeItem item = new RecipeItemImpl(ingredient, quantity, true, quantifiable);

        Assertions.assertTrue(item.optional());
    }

    @Test
    public void testIngredient() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        float quantity = 15f;
        RecipeItemDisplay quantifiable = new Quantifiable();
        RecipeItem item = new RecipeItemImpl(ingredient, quantity, true, quantifiable);

        Assertions.assertEquals(ingredient, item.ingredient());
    }

}
