package UseCases;

import Commands.Command;
import Commands.Implementations.CommandImpl;
import Entities.*;
import Entities.Implementations.*;
import Entities.Implementations.IngredientImpl;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeStorageImpl;
import Storages.IngredientStorage;
import Storages.RecipeStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Entities.Ingredient;

import java.util.*;

public class UseCaseTest {

    IngredientStorageImpl ingredientStorage;
    RecipeStorageImpl recipeStorage;
    IngredientStorageImpl fridge;

    IngredientImpl ingredient1;
    IngredientImpl ingredient2;

    @BeforeEach
    public void setup() {
        // create tags
        TagImpl tag1 = new TagImpl("Gluten");
        TagImpl tag2 = new TagImpl("Dairy");
        TagImpl tag3 = new TagImpl("Non-Vegan");

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
        recipeItems1.add((VolumetricRecipeItem) item1);
        recipeItems1.add((QuantityRecipeItem) item2);
        recipeItems1.add((VolumetricRecipeItem) item3);
        recipeItems1.add((QuantityRecipeItem) item4);
        recipeItems1.add((VolumetricRecipeItem) item5);
        recipeItems1.add((VolumetricRecipeItem) item6);

        List<RecipeItem> recipeItems2 = new ArrayList<>();
        recipeItems2.add((VolumetricRecipeItem) item1);
        recipeItems2.add((VolumetricRecipeItem) item5);
        recipeItems2.add((VolumetricRecipeItem) item6);

        RecipeImpl recipe1 = new RecipeImpl("Cookies", "Yummy chocolate chip cookies, best in the world.", Collections.singletonList("instructions"), recipeItems1);
        RecipeImpl recipe2 = new RecipeImpl("Bread", "Yummy chocolate chip cookies, best in the world.", Collections.singletonList("instructions"), recipeItems2);

        //@create fridge
        this.ingredientStorage = new IngredientStorageImpl();
        this.fridge = new IngredientStorageImpl();
        this.recipeStorage = new RecipeStorageImpl();

        // add the ingredients that the user has to the fridge (holds whats in the users fridge)
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
     * Test the matcher use case
     */
    @Test
    public void testMatcherRun() {
        // Make a command, populate it with the correct things.
        CommandImpl command = new CommandImpl();
        command.put("Fridge", "flour,egg");

        List<Recipe> recipes = new ArrayList<>(this.recipeStorage.recipes());
        MatcherUseCase usecase = new MatcherUseCase(this.ingredientStorage, this.recipeStorage);

        Assertions.assertEquals(usecase.run(command).recipes(), recipes);
    }


    @Test
    public void testAddToFridge() {

        CommandImpl command = new CommandImpl();
        command.put("addtofridge", "oil,chocolate chips");
        FridgeUseCase usecase = new FridgeUseCase(fridge, ingredientStorage);

        TagImpl tag1 = new TagImpl("Gluten");
        TagImpl tag2 = new TagImpl("Dairy");
        TagImpl tag3 = new TagImpl("Non-Vegan");

        List<Tag> list1 = new ArrayList<>();
        list1.add(tag1);

        List<Tag> list2 = new ArrayList<>();
        list2.add(tag3);

        List<Tag> list3 = new ArrayList<>();
        list3.add(tag3);
        list3.add(tag2);

        IngredientImpl ingredient1 = new IngredientImpl("flour",list1);
        IngredientImpl ingredient2 = new IngredientImpl("egg", list2);
        IngredientImpl ingredient3 = new IngredientImpl("oil", Collections.emptyList());
        IngredientImpl ingredient4 = new IngredientImpl("chocolate chips", list3);

        IngredientStorageImpl expected1 = new IngredientStorageImpl();

        expected1.add(ingredient2);
        expected1.add(ingredient4);
        expected1.add(ingredient1);
        expected1.add(ingredient3);
        Ingredient test1 =  ingredientStorage.findByNameExact("oil").iterator().next();
        Ingredient test2 =  ingredientStorage.findByNameExact("chocolate chips").iterator().next();

        Assertions.assertTrue(usecase.run(command).ingredients().contains(test1));
        Assertions.assertTrue(usecase.run(command).ingredients().contains(test2));

    }

    @Test
    public void testGetFridgeStorage() {
        IngredientStorageImpl mockStorage = new IngredientStorageImpl();

        mockStorage.add(this.ingredient1);
        mockStorage.add(this.ingredient2);

        // Create command
        CommandImpl command = new CommandImpl();
        command.put("Fridge", "flour,egg");

        MatcherUseCase usecase = new MatcherUseCase(this.ingredientStorage, this.recipeStorage);
        Assertions.assertTrue(usecase.getFridgeStorage(command).ingredients().containsAll(mockStorage.ingredients()));
        }

    @Test
    public void testRemoveFromFridge(){
        CommandImpl command = new CommandImpl();
        command.put("removefromfridge", "flour");
        FridgeUseCase usecase = new FridgeUseCase(fridge, ingredientStorage);

        Ingredient test1 =  ingredientStorage.findByNameExact("flour").iterator().next();
        Ingredient test2 =  ingredientStorage.findByNameExact("egg").iterator().next();

        Assertions.assertFalse(usecase.run(command).ingredients().contains(test1));
        Assertions.assertTrue(usecase.run(command).ingredients().contains(test2));

    }

}
