package Entities.Implementations;

import Entities.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class QuantityRecipeItemTest {

    @Test
    public void testDisplay() {
       // tests quantity as 1 and no vowel
        Ingredient ingredient = new IngredientImpl("lemon", Collections.emptyList());
        QuantityRecipeItem quantiyitem1 = new QuantityRecipeItem(ingredient, 1, false);

        Assertions.assertEquals("1 lemon", quantiyitem1.display());


        // tests quantity less than 1 and no vowel
        QuantityRecipeItem quantiyitem2 = new QuantityRecipeItem(ingredient, 0.5f, false);

        Assertions.assertEquals("0.5 of a lemon", quantiyitem2.display());

        // test quantity greater than 1 and no vowel
        QuantityRecipeItem quantiyitem3 = new QuantityRecipeItem(ingredient, 20, false);

        Assertions.assertEquals("20 lemons", quantiyitem3.display());

        //test less than 1 with a vowel
        Ingredient ingredient2= new IngredientImpl("apple", Collections.emptyList());
        QuantityRecipeItem quantiyitem4 = new QuantityRecipeItem(ingredient2, 0.5f, false);

        Assertions.assertEquals("0.5 of an apple", quantiyitem4.display());

    }
}
