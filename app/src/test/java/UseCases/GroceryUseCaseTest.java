package UseCases;

import Entities.Implementations.*;
import Entities.Ingredient;
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

public class GroceryUseCaseTest {
    IngredientStorageImpl ingredientStorage;
    RecipeStorageImpl recipeStorage;
    IngredientStorageImpl fridge;
    IngredientStorageImpl groceryList;

    IngredientImpl ingredient1;
    IngredientImpl ingredient2;
    IngredientImpl ingredient3;
    IngredientImpl ingredient4;
    IngredientImpl ingredient5;
    IngredientImpl ingredient6;

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
        command.put("listRecipeItems", "");

        GroceryUseCase useCase = new GroceryUseCase(this.fridge, this.recipeStorage, this.groceryList);

        // Fridge only contains ingredient1 and ingredient2
        // we check to see that the Output response contains ingredient3-6
        Assertions.assertTrue(useCase.run(command).data().contains(this.ingredient3));
        Assertions.assertTrue(useCase.run(command).data().contains(this.ingredient4));
        Assertions.assertTrue(useCase.run(command).data().contains(this.ingredient5));
        Assertions.assertTrue(useCase.run(command).data().contains(this.ingredient6));

        // We check to see that the grocery list does contain ingredients3-6 as well
        Assertions.assertTrue(this.groceryList.contains(this.ingredient3));
        Assertions.assertTrue(this.groceryList.contains(this.ingredient4));
        Assertions.assertTrue(this.groceryList.contains(this.ingredient5));
        Assertions.assertTrue(this.groceryList.contains(this.ingredient6));


    }

    /**
     * Test the GroceryUseCase and see if items in grocery get imported to fridge
     * Also checks that grocery is emptied once items are imported.
     */
    @Test
    public void testImportToFridge() {
        CommandImpl command = new CommandImpl();
        command.put("importRecipeItems", "");

        GroceryUseCase useCase = new GroceryUseCase(this.fridge, this.recipeStorage, this.groceryList);
        this.groceryList.add(this.ingredient5);
        this.groceryList.add(this.ingredient6);


        useCase.run(command);
//         Checking that fridge contains ingredients that were emptied from the grocery list
        Assertions.assertTrue(useCase.fridge.contains(this.ingredient5));
        Assertions.assertTrue(useCase.fridge.contains(this.ingredient6));

        // checking that groceryList is now empty
        Assertions.assertFalse(useCase.groceryList.contains(this.ingredient5));
        Assertions.assertFalse(useCase.groceryList.contains(this.ingredient6));




    }
}
