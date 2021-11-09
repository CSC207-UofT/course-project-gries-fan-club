package Entities;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.VolumetricRecipeItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Collections;

public class QuantityRecipeItemTest {

    @Test
    public void testDisplayOneQuantity() {
        IngredientImpl ingredient = new IngredientImpl("lemon", Collections.emptyList());
        VolumetricRecipeItem quantiyitem = new VolumetricRecipeItem(ingredient, 1, false);

        Assertions.assertEquals("1 lemon", quantiyitem.display());

    }

    @Test
    public void testDisplaySmallQuantity() {
        IngredientImpl ingredient = new IngredientImpl("lemon", Collections.emptyList());
        VolumetricRecipeItem quantiyitem = new VolumetricRecipeItem(ingredient, 0.5f, false);

        Assertions.assertEquals("0.5 of a lemon", quantiyitem.display());

    }

    @Test
    public void testDisplayLargeQuantity() {
        IngredientImpl ingredient = new IngredientImpl("lemon", Collections.emptyList());
        VolumetricRecipeItem quantiyitem = new VolumetricRecipeItem(ingredient, 20, false);

        Assertions.assertEquals("20 lemons", quantiyitem.display());
    }
}
