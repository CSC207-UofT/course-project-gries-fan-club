package test.java.Entities;
import org.junit.Test;
import static org.junit.Assert.*;
import main.java.Entities.Ingredient;
import main.java.Entities.Item;

import java.util.Collections;

public class ItemTest {

    @Test
    public void testQuantity() {
        Ingredient ingredient = new Ingredient("apple", Collections.emptyList());
        int quantity = 15;
        Item item = new Item(ingredient, quantity);

        assertEquals(15, item.quantity());

    }

    @Test
    public void testOptional() {
        Ingredient ingredient = new Ingredient("apple", Collections.emptyList());
        int quantity = 15;
        Item item = new Item(ingredient, quantity);

        assertEquals(true, item.optional(true));

    }

    @Test
    public void testIngredient() {
        Ingredient ingredient = new Ingredient("apple", Collections.emptyList());
        int quantity = 15;
        Item item = new Item(ingredient, quantity);

        assertEquals(ingredient, item.ingredient());
    }

}
