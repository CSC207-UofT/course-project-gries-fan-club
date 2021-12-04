package UseCases;

import Storages.IngredientStorage;
import Storages.RecipeStorage;

public class GroceryUseCase {
    /**
     * The grocery displays gives all ingredients you currently need to buy.
     */
    IngredientStorage fridge;
    final RecipeStorage recipeStorage;
    IngredientStorage grocery;

    public GroceryUseCase(IngredientStorage fridge, RecipeStorage recipeStorage, IngredientStorage grocery) {
        this.fridge = fridge;
        this.recipeStorage = recipeStorage;
        this.grocery = grocery;
    }
    /**
     * Return all ingredients needed if listRecipeItems provided in command
     * Return all items in grocery and import to fridge.
     * @param command
     * @return IngredientStorageResponseImpl containing a list of ingredients found
     */

    public Response run(Command command) {

    }


}
