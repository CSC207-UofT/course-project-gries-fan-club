package Controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrontEndTest {

    @Test
    public void testFrontEndIngredient() throws Exception {
        FrontEnd frontEnd = new FrontEnd();
        Assertions.assertEquals(frontEnd.ingredientStorage(), "");
    }

    @Test
    public void testFrontEndRecipe() throws Exception {
        FrontEnd frontEnd = new FrontEnd();

        Assertions.assertEquals(frontEnd.recipeStorage().recipes().toString(), "");
    }

    @Test
    public void testFrontEndRecipeItem() throws Exception {
        FrontEnd frontEnd = new FrontEnd();
        Assertions.assertEquals(frontEnd.recipeItemStorage(), "");
    }

    @Test
    public void testFrontEndTags() throws Exception {
        FrontEnd frontEnd = new FrontEnd();
        Assertions.assertEquals(frontEnd.tagStorage().toString(), "[Non-Kosher, Gluten, Non-Halal, Dairy, Meat]");
    }
}
