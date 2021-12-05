package Entities;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.RecipeItemImpl;
import RecipeItemDisplayers.Quantifiable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class QuantityRecipeItemTest {

    @Test
    public void testDisplay() {
       // tests quantity as 1 and no vowel
        Ingredient ingredient = new IngredientImpl("lemon", Collections.emptyList());
        RecipeItemDisplay quantifiable = new Quantifiable();
        RecipeItem quantiyitem1 = new RecipeItemImpl(ingredient, 1, false, quantifiable);

        Assertions.assertEquals("1 lemon", quantiyitem1.display());


        // tests quantity less than 1 and no vowel
        RecipeItem quantiyitem2 = new RecipeItemImpl(ingredient, 0.5f, false, quantifiable);

        Assertions.assertEquals("0.5 of a lemon", quantiyitem2.display());

        // test quantity greater than 1 and no vowel
        RecipeItem quantiyitem3 = new RecipeItemImpl(ingredient, 20, false, quantifiable);

        Assertions.assertEquals("20 lemons", quantiyitem3.display());

        //test less than 1 with a vowel
        Ingredient ingredient2= new IngredientImpl("apple", Collections.emptyList());
        RecipeItem quantiyitem4 = new RecipeItemImpl(ingredient2, 0.5f, false, quantifiable);

        Assertions.assertEquals("0.5 of an apple", quantiyitem4.display());

    }
}
