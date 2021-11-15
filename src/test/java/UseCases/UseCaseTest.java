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
        IngredientImpl ingredient1 = new IngredientImpl("flour",list1);
        IngredientImpl ingredient2 = new IngredientImpl("egg", list2);
        IngredientImpl ingredient3 = new IngredientImpl("oil", Collections.emptyList());
        IngredientImpl ingredient4 = new IngredientImpl("chocolate chips", list3);
        IngredientImpl ingredient5 = new IngredientImpl("water", Collections.emptyList());
        IngredientImpl ingredient6 = new IngredientImpl("baking soda", Collections.emptyList());

        //create Recipe Items for the recipe
        VolumetricRecipeItem item1 = new VolumetricRecipeItem(ingredient1, 250f, false);
        QuantityRecipeItem item2 = new QuantityRecipeItem(ingredient2, 2f, false);
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

        // add the ingredients that the user has to the fridge
        fridge.add(ingredient1);
        fridge.add(ingredient2);

        // add to the main ingredients
        this.ingredientStorage.add(ingredient1);
        this.ingredientStorage.add(ingredient2);
        this.ingredientStorage.add(ingredient3);
        this.ingredientStorage.add(ingredient4);
        this.ingredientStorage.add(ingredient5);
        this.ingredientStorage.add(ingredient6);

        // add to the storage
        this.recipeStorage.add(recipe1);
        this.recipeStorage.add(recipe2);
    }

    @Test
    public void testGetCommandFridge() {
        CommandImpl command = new CommandImpl();
        command.put("Fridge", "Apple, Orange");
        MatcherUseCase usecase = new MatcherUseCase(this.ingredientStorage, this.recipeStorage);
        //@todo Add an assertion here
    }
    @Test
    public void testAddToFridge() {
        CommandImpl command = new CommandImpl();
        command.put("addtofridge", "oil, chocolate chips");
        FridgeUseCase usecase = new FridgeUseCase(fridge, ingredientStorage);

        Assertions.assertTrue(usecase.run(command),

    }


}


