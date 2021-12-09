package Controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class FrontEndTest {
    FrontEnd frontEnd;

    @BeforeEach
    public void setup() throws Exception {
        String workingDirectory = Paths.get("").toAbsolutePath().toString() + "/src/test/java/Controllers/";
        String ingredientPath = workingDirectory + "ingredientsTest.json";
        String tagPath = workingDirectory + "tagsTest.json";
        String recipeItemPath = workingDirectory + "recipeItemsTest.json";
        String recipePath = workingDirectory + "recipesTest.json";
        this.frontEnd = new FrontEnd(ingredientPath, tagPath, recipeItemPath, recipePath);
    }

    @Test
    public void testFrontEndIngredient() {
        Assertions.assertEquals(this.frontEnd.ingredientStorage().size(), 21);
    }

    @Test
    public void testFrontEndRecipe() {
        Assertions.assertEquals(this.frontEnd.recipeStorage().size(), 5);
    }

    @Test
    public void testFrontEndRecipeItem() {
        Assertions.assertEquals(this.frontEnd.recipeItemStorage().size(), 24);
    }

    @Test
    public void testFrontEndTags()  {
        Assertions.assertEquals(this.frontEnd.tagStorage().size(), 5);
    }
}
