package Entities;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.VolumetricRecipeItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Collections;

public class QuantityRecipeItemTest {

    @Test
    public void testDisplay() {
       // tests quantity as 1 and no vowel
        IngredientImpl ingredient1 = new IngredientImpl("lemon", Collections.emptyList());
        VolumetricRecipeItem quantiyitem1 = new VolumetricRecipeItem(ingredient1, 1, false);

        Assertions.assertEquals("1 lemon", quantiyitem1.display());


        // tests quantity less than 1 and no vowel
        IngredientImpl ingredient2 = new IngredientImpl("lemon", Collections.emptyList());
        VolumetricRecipeItem quantiyitem2 = new VolumetricRecipeItem(ingredient2, 0.5f, false);

        Assertions.assertEquals("0.5 of a lemon", quantiyitem2.display());

        // test quantity greater than 1 and no vowel
        IngredientImpl ingredient3= new IngredientImpl("lemon", Collections.emptyList());
        VolumetricRecipeItem quantiyitem3 = new VolumetricRecipeItem(ingredient3, 20, false);

        Assertions.assertEquals("20 lemons", quantiyitem3.display());

        //test less than 1 with a vowel
        IngredientImpl ingredient4= new IngredientImpl("apple", Collections.emptyList());
        VolumetricRecipeItem quantiyitem4 = new VolumetricRecipeItem(ingredient4, 0.5f, false);

        Assertions.assertEquals("0.5 of an apple", quantiyitem4.display());

    }
}
