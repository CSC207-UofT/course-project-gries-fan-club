package Controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FrontEndTest {
    FrontEnd frontEnd;

    Path basePath = Paths.get("src", "test", "resources");
    String ingredientPath = basePath.resolve("ingredientsTest.json").toString();
    String tagPath = basePath.resolve("tagsTest.json").toString();
    String recipeItemPath = basePath.resolve("recipeItemsTest.json").toString();
    String recipePath = basePath.resolve("recipesTest.json").toString();

    @BeforeEach
    public void setup() throws Exception {
        this.frontEnd = new FrontEnd(ingredientPath, tagPath, recipeItemPath, recipePath);
    }

    @Test
    public void testFrontEndIngredient() {
        Assertions.assertEquals(this.frontEnd.ingredientStorage().size(), 5);
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

    @Test
    public void addToFridgeTest() {
        this.frontEnd.addToFridge("Beef,Salt");
        Assertions.assertEquals(1, this.frontEnd.fridge().findByNameExact("Salt").size());
        Assertions.assertEquals(1, this.frontEnd.fridge().findByNameExact("Beef").size());
    }

    @Test
    public void removeFromFridgeTest() {
        this.frontEnd.addToFridge("Beef,Salt");
        this.frontEnd.removeFromFridge("Salt");
        Assertions.assertEquals(1, this.frontEnd.fridge().size());
    }

    @Test
    public void saveFridgeTest() throws Exception {
        this.frontEnd.addToFridge("Beef,Salt,Italian Seasoning");
        this.frontEnd.saveFridge(Paths.get("src", "test", "java", "Controllers", "fridge2.json").toString());
    }

    @Test
    public void updateFridgeTest() throws Exception {
        FrontEnd frontEnd2 = new FrontEnd(ingredientPath, tagPath, recipeItemPath, recipePath);

        Assertions.assertEquals(0, frontEnd2.fridge.size());
        frontEnd2.updateFridge(basePath.resolve("fridge.json").toString(), tagPath);
        Assertions.assertEquals(3, frontEnd2.fridge().size());
    }


    @Test
    public void testMatcherRecipes() throws Exception {
        FrontEnd frontEnd3 = new FrontEnd(ingredientPath, tagPath, recipeItemPath, recipePath);
        frontEnd3.updateFridge(basePath.resolve("fridge3.json").toString(), tagPath);
        Assertions.assertEquals(2, frontEnd3.matchFridgeToRecipes(2).size());
    }

}
