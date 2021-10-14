package test.java.Entities;
import org.junit.Test;
import static org.junit.Assert.*;
import main.java.Entities.IngredientImpl;
import main.java.Entities.ItemImpl;

import java.util.Collections;

public class ItemTest {

    @Test
    public void testQuantity() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        int quantity = 15;
        ItemImpl item = new ItemImpl(ingredient, quantity);

        assertEquals(15, item.quantity());

    }

    @Test
    public void testOptional() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        int quantity = 15;
        ItemImpl item = new ItemImpl(ingredient, quantity, true);

        assertTrue(item.optional(true));
    }

    @Test
    public void testIngredient() {
        IngredientImpl ingredient = new IngredientImpl("apple", Collections.emptyList());
        int quantity = 15;
        ItemImpl item = new ItemImpl(ingredient, quantity);

        assertEquals(ingredient, item.ingredient());
    }

}
