package UseCases;

import Entities.Implementations.*;
import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Tag;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeStorageImpl;
import Storages.Implementations.TagStorageImpl;
import Storages.IngredientStorage;
import Storages.RecipeStorage;
import Storages.TagStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroceryUseCaseTest {
    IngredientStorage ingredientStorage;
    RecipeStorage recipeStorage;
    IngredientStorage fridge;
    IngredientStorage groceryList;
    TagStorage tagStorage;

    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient ingredient3;
    Ingredient ingredient4;
    Ingredient ingredient5;
    Ingredient ingredient6;

    Recipe recipe1;
    Recipe recipe2;


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
        this.ingredient3 = new IngredientImpl("oil", Collections.emptyList());
        this.ingredient4 = new IngredientImpl("chocolate chips", list3);
        this.ingredient5 = new IngredientImpl("water", Collections.emptyList());
        this.ingredient6 = new IngredientImpl("baking soda", Collections.emptyList());

        //create Recipe Items for the recipe
        VolumetricRecipeItem item1 = new VolumetricRecipeItem(this.ingredient1, 250f, false);
        QuantityRecipeItem item2 = new QuantityRecipeItem(this.ingredient2, 2f, false);
        VolumetricRecipeItem item3 = new VolumetricRecipeItem(this.ingredient3, 100f, false);
        QuantityRecipeItem item4 = new QuantityRecipeItem(this.ingredient4, 55f, false);
        VolumetricRecipeItem item5 = new VolumetricRecipeItem(this.ingredient5, 125f, false);
        VolumetricRecipeItem item6 = new VolumetricRecipeItem(this.ingredient6, 5f, false);
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
        this.groceryList = new IngredientStorageImpl();

        // add the ingredients that the user has to the fridge (holds what's in the users' fridge)
        fridge.add(this.ingredient1);
        fridge.add(this.ingredient2);

        // add to the main ingredients (holds all the ingredients in our database0
        this.ingredientStorage.add(this.ingredient1);
        this.ingredientStorage.add(this.ingredient2);
        this.ingredientStorage.add(this.ingredient3);
        this.ingredientStorage.add(this.ingredient4);
        this.ingredientStorage.add(this.ingredient5);
        this.ingredientStorage.add(this.ingredient6);

        // add to the recipe storage (all in the recipes in our app)
        this.recipeStorage.add(recipe1);
        this.recipeStorage.add(recipe2);
    }

    /**
     * Tests the run command of the Grocery use case
     * Specifically, sees if all items needed to make recipes are added to the grocery
     */
    @Test
    public void testListRecipeItems() {
        CommandImpl command = new CommandImpl();
        command.put("addToList", "water");

        this.groceryList.add(ingredient5);
        GroceryUseCase useCase = new GroceryUseCase(this.fridge, this.recipeStorage, this.groceryList);

        // We check to see that the grocery list does contain ingredients3-6 as well
        Assertions.assertTrue(useCase.run(command).get("Grocery").contains(this.ingredient5.name()));

    }

    /**
     * Test the GroceryUseCase and see if items in grocery get imported to fridge
     * Also checks that grocery is emptied once items are imported.
     */
    @Test
    public void testImportToFridge() {
        CommandImpl command = new CommandImpl();
        command.put("importRecipeItems", "water");
        this.groceryList.add(ingredient5);
        GroceryUseCase useCase = new GroceryUseCase(this.fridge, this.recipeStorage, this.groceryList);
        Assertions.assertTrue(useCase.run(command).get("Grocery").contains(this.ingredient5.name()));
        Assertions.assertFalse(this.groceryList.contains(ingredient5));




//         Checking that fridge contains ingredients that were emptied from the grocery list

    }
    @Test
    public void testRemoveFromGroceryList() {
        CommandImpl command = new CommandImpl();
        command.put("removeFromGroceryList", "oil,chocolate chips,baking soda");

        GroceryUseCase useCase = new GroceryUseCase(this.fridge, this.recipeStorage, this.groceryList);
        this.groceryList.add(this.ingredient3);
        this.groceryList.add(this.ingredient4);
        this.groceryList.add(this.ingredient5);
        this.groceryList.add(this.ingredient6);

        useCase.run(command);

        // Checks that grocery List only contains ingredient 5 now (only contains water)
        Assertions.assertTrue(useCase.groceryList.contains(this.ingredient5));

        // checks that grocery List does not contain ingredient 3,4,6
        Assertions.assertFalse(useCase.groceryList.contains(this.ingredient3));
        Assertions.assertFalse(useCase.groceryList.contains(this.ingredient4));
        Assertions.assertFalse(useCase.groceryList.contains(this.ingredient6));

        // Checks that fridge does contain ingredient 3,4,6
        Assertions.assertTrue(useCase.fridge.contains(this.ingredient3));
        Assertions.assertTrue(useCase.fridge.contains(this.ingredient4));
        Assertions.assertTrue(useCase.fridge.contains(this.ingredient6));

    }
}
