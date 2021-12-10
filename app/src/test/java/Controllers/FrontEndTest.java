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
        this.frontEnd.saveFridge(Paths.get("").toAbsolutePath().toString() + "/src/test/java/Controllers/" + "fridge2.json");
    }

    @Test
    public void updateFridgeTest() throws Exception {
        String workingDirectory = Paths.get("").toAbsolutePath().toString() + "/src/test/java/Controllers/";
        String ingredientPath = workingDirectory + "ingredientsTest.json";
        String tagPath = workingDirectory + "tagsTest.json";
        String recipeItemPath = workingDirectory + "recipeItemsTest.json";
        String recipePath = workingDirectory + "recipesTest.json";

        FrontEnd frontEnd2 = new FrontEnd(ingredientPath, tagPath, recipeItemPath, recipePath);

        Assertions.assertEquals(0, frontEnd2.fridge.size());
        frontEnd2.updateFridge(workingDirectory + "fridge.json", tagPath);
        Assertions.assertEquals(3, frontEnd2.fridge().size());
    }


    @Test
    public void testMatcherRecipes() throws Exception {
        String workingDirectory = Paths.get("").toAbsolutePath().toString() + "/src/test/java/Controllers/";
        String ingredientPath = workingDirectory + "ingredientsTest.json";
        String tagPath = workingDirectory + "tagsTest.json";
        String recipeItemPath = workingDirectory + "recipeItemsTest.json";
        String recipePath = workingDirectory + "recipesTest.json";

        FrontEnd frontEnd3 = new FrontEnd(ingredientPath, tagPath, recipeItemPath, recipePath);
        frontEnd3.updateFridge(workingDirectory + "fridge3.json", tagPath);
        Assertions.assertEquals(2, frontEnd3.matchFridgeToRecipes(2).size());
    }

}
