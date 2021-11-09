package Entities;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.VolumetricRecipeItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Collections;

public class VolumetricRecipeItemTest {

    @Test
    public void testDisplay() {
        IngredientImpl ingredient = new IngredientImpl("flour", Collections.emptyList());
        VolumetricRecipeItem volumeitem = new VolumetricRecipeItem(ingredient, 100, false);

        Assertions.assertEquals("100 ml of flour", volumeitem.display());

    }

}
