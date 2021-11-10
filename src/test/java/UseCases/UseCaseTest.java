package UseCases;

import Entities.Exceptions.InvalidRowShape;
import Entities.Implementations.IngredientImpl;
import Entities.Implementations.RecipeImpl;
import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Loaders.Implementations.RowImpl;
import Loaders.Row;
import Storages.Fridge;
import Storages.Implementations.AbstractStorage;
import Storages.IngredientStorage;
import Storages.Storage;
import org.junit.jupiter.api.Assertions;
import Entities.Implementations.IngredientImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.Ingredient;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTest {
    /**
     * A test that tests whether a use case has correctly executed
     */
    @Test
    public void testUseCase() {
        //@Todo create Ingredient Storage
        //@Todo creates ingredients
        IngredientImpl ingredient1 = new IngredientImpl("flour", Collections.emptyList())
        IngredientImpl ingredient2 = new IngredientImpl("egg", Collections.emptyList())
        IngredientImpl ingredient3 = new IngredientImpl("oil", Collections.emptyList())
        IngredientImpl ingredient4 = new IngredientImpl("chocolate chips", Collections.emptyList())
        IngredientImpl ingredient5 = new IngredientImpl("water", Collections.emptyList())
        IngredientImpl ingredient6 = new IngredientImpl("baking soda", Collections.emptyList())

        //@Todo create Recipe Items for the recipe
        VolumetricRecipeItem item1 = new VolumetricRecipeItem(ingredient1, 250f, false);
        QuantityRecipeItem item2 = new QuantityRecipeItem(ingredient2, 2f, false);
        VolumetricRecipeItem item3 = new VolumetricRecipeItem(ingredient3, 100f, false);
        QuantityRecipeItem item4 = new QuantityRecipeItem(ingredient4, 55f, false);
        VolumetricRecipeItem item5 = new VolumetricRecipeItem(ingredient5, 125f, false);
        VolumetricRecipeItem item6 = new VolumetricRecipeItem(ingredient6, 5f, false);
        //@Todo create recipes
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

        //@Todo create fridge
        Fridge fridge = new Fridge() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
        // add the ingredients that the user has to the fridge
        fridge.add(ingredient1);
        fridge.add(ingredient2);
        fridge.add(ingredient3);
        fridge.add(ingredient4);
        //@Todo create the matcher and execute it.

    }
}
