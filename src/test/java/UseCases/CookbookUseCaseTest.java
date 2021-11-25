package UseCases;

import Commands.Implementations.CommandImpl;
import Entities.Implementations.*;
import Entities.RecipeItem;
import Entities.Tag;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeStorageImpl;
import Storages.Implementations.TagStorageImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CookbookUseCaseTest {
    IngredientStorageImpl ingredientStorage;
    RecipeStorageImpl recipeStorage;
    IngredientStorageImpl fridge;

    IngredientImpl ingredient1;
    IngredientImpl ingredient2;

    RecipeImpl recipe1;
    RecipeImpl recipe2;

    TagStorageImpl tagStorage;

    @BeforeEach
    public void setup() {
        // create tags
        TagImpl tag1 = new TagImpl("Gluten");
        TagImpl tag2 = new TagImpl("Dairy");
        TagImpl tag3 = new TagImpl("Non-Vegan");
        this.tagStorage = new TagStorageImpl();

        // Add tags to main storage of tags
        this.tagStorage.add(tag1);
        this.tagStorage.add(tag2);
        this.tagStorage.add(tag3);

        List<Tag> list1 = new ArrayList<>();
        list1.add(tag1);

        List<Tag> list2 = new ArrayList<>();
        list2.add(tag3);

        List<Tag> list3 = new ArrayList<>();
        list3.add(tag3);
        list3.add(tag2);

        // creates ingredients
        this.ingredient1 = new IngredientImpl("flour",list1);
        this.ingredient2 = new IngredientImpl("egg", list2);
        IngredientImpl ingredient3 = new IngredientImpl("oil", Collections.emptyList());
        IngredientImpl ingredient4 = new IngredientImpl("chocolate chips", list3);
        IngredientImpl ingredient5 = new IngredientImpl("water", Collections.emptyList());
        IngredientImpl ingredient6 = new IngredientImpl("baking soda", Collections.emptyList());

        //create Recipe Items for the recipe
        VolumetricRecipeItem item1 = new VolumetricRecipeItem(this.ingredient1, 250f, false);
        QuantityRecipeItem item2 = new QuantityRecipeItem(this.ingredient2, 2f, false);
        VolumetricRecipeItem item3 = new VolumetricRecipeItem(ingredient3, 100f, false);
        QuantityRecipeItem item4 = new QuantityRecipeItem(ingredient4, 55f, false);
        VolumetricRecipeItem item5 = new VolumetricRecipeItem(ingredient5, 125f, false);
        VolumetricRecipeItem item6 = new VolumetricRecipeItem(ingredient6, 5f, false);
        //create recipes
        List<RecipeItem> recipeItems1 = new ArrayList<>();
        recipeItems1.add(item1);
        recipeItems1.add(item2);
        recipeItems1.add(item3);
        recipeItems1.add(item4);
        recipeItems1.add(item5);
        recipeItems1.add(item6);

        List<RecipeItem> recipeItems2 = new ArrayList<>();
        recipeItems2.add(item1);
        recipeItems2.add(item5);
        recipeItems2.add(item6);

        RecipeImpl recipe1 = new RecipeImpl("Cookies", "Yummy chocolate chip cookies, best in the world.", Collections.singletonList("instructions"), recipeItems1);
        RecipeImpl recipe2 = new RecipeImpl("Bread", "Yummy chocolate chip cookies, best in the world.", Collections.singletonList("instructions"), recipeItems2);

        this.recipe1 = recipe1;
        this.recipe2 = recipe2;

        //Create fridge
        this.ingredientStorage = new IngredientStorageImpl();
        this.fridge = new IngredientStorageImpl();
        this.recipeStorage = new RecipeStorageImpl();

        // add the ingredients that the user has to the fridge (holds what's in the users' fridge)
        fridge.add(this.ingredient1);
        fridge.add(this.ingredient2);

        // add to the main ingredients (holds all the ingredients in our database0
        this.ingredientStorage.add(this.ingredient1);
        this.ingredientStorage.add(this.ingredient2);
        this.ingredientStorage.add(ingredient3);
        this.ingredientStorage.add(ingredient4);
        this.ingredientStorage.add(ingredient5);
        this.ingredientStorage.add(ingredient6);

        // add to the recipe storage (all in the recipes in our app)
        this.recipeStorage.add(recipe1);
        this.recipeStorage.add(recipe2);
    }

    /**
     * Tests the run command of the Cookbook use case
     * Specifically, sees if all the recipes are being returned when FindAllRecipes command is run
     */
    @Test
    public void testFindAllRecipes() {
        CommandImpl command = new CommandImpl();
        command.put("FindAllRecipes", "");

        CookbookUseCase useCase = new CookbookUseCase(this.recipeStorage, this.tagStorage);

        Assertions.assertTrue(useCase.run(command).recipes.contains(this.recipe1));
        Assertions.assertTrue(useCase.run(command).recipes.contains(this.recipe2));
    }

    /**
     * Test the cookbook use case but now seeing it it returns all he recipes based on given tags
     * Specifically, the recipes that do NOT contain those tags since each tag is positive
     * Ex. {FindRecipesByTags : "Dairy"}, will return all recipes that do not contain Dairy.
     */
    @Test
    public void testFindRecipesWithTags() {
        CommandImpl command = new CommandImpl();
        command.put("FindRecipesByTags", "Dairy, Non-Vegan");

        CookbookUseCase useCase = new CookbookUseCase(this.recipeStorage, this.tagStorage);

        Assertions.assertTrue(useCase.run(command).recipes.contains(this.recipe2));
    }
}
