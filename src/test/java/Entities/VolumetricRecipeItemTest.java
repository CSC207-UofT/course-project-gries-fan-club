package Entities;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.VolumetricRecipeItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class VolumetricRecipeItemTest {

    @Test
    public void testVolumetricDisplay() {
        IngredientImpl ingredient = new IngredientImpl("flour", Collections.emptyList());
        VolumetricRecipeItem volumeItem = new VolumetricRecipeItem(ingredient, 100, false);
        Assertions.assertEquals("100ml of flour", volumeItem.display());

    }

}
