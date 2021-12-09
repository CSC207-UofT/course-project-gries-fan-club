package Controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrontEndTest {

    @Test
    public void testFrontEndIngredient() throws Exception {
        FrontEnd frontEnd = new FrontEnd();
        Assertions.assertEquals(frontEnd.ingredientStorage().size(), 21);
    }

    @Test
    public void testFrontEndRecipe() throws Exception {
        FrontEnd frontEnd = new FrontEnd();
        Assertions.assertEquals(frontEnd.recipeStorage().size(), 5);
    }

    @Test
    public void testFrontEndRecipeItem() throws Exception {
        FrontEnd frontEnd = new FrontEnd();
        Assertions.assertEquals(frontEnd.recipeItemStorage().size(), 24);
    }

    @Test
    public void testFrontEndTags() throws Exception {
        FrontEnd frontEnd = new FrontEnd();
        Assertions.assertEquals(frontEnd.tagStorage().size(), 5);
    }
}
