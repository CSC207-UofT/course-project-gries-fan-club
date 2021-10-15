package Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class ItemTest {

    @Test
    public void testQuantity() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        int quantity = 15;
        ItemImpl item = new ItemImpl(ingredient, quantity);

        Assertions.assertEquals(15, item.quantity());

    }

    @Test
    public void testOptional() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        int quantity = 15;
        ItemImpl item = new ItemImpl(ingredient, quantity, true);

        Assertions.assertTrue(item.optional());
    }

    @Test
    public void testIngredient() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        int quantity = 15;
        ItemImpl item = new ItemImpl(ingredient, quantity);

        Assertions.assertEquals(ingredient, item.ingredient());
    }

}
