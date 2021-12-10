package Controllers;

import Storages.IngredientStorage;
import Storages.RecipeStorage;
import Storages.TagStorage;
import UseCases.*;

/**
 * Calls all of the run functions from the use case, providing the command
 */
public class RunController {
    UseCase usecase;

    /**
     * Creates matcher use case
     */
    public RunController(IngredientStorage ingredientStorage, RecipeStorage recipeStorage) {
        this.usecase = new MatcherUseCase(ingredientStorage, recipeStorage);
    }

    /**
     * Makes the cookbook use case
     * @param recipeStorage
     * @param tagStorage
     */
    public RunController(RecipeStorage recipeStorage, TagStorage tagStorage) {
        this.usecase = new CookbookUseCase(recipeStorage, tagStorage);
    }

    /**
     * Make a fridge use case
     * @param fridge
     * @param ingredientStorage
     */
    public RunController(IngredientStorage fridge, IngredientStorage ingredientStorage) {
        this.usecase = new FridgeUseCase(fridge, ingredientStorage);
    }

    /**
     * Create the GroceryUseCase from the parameters given
     * @param fridge
     * @param recipeStorage
     * @param groceryList
     */
    public RunController(IngredientStorage fridge, RecipeStorage recipeStorage, IngredientStorage groceryList) {
        this.usecase = new GroceryUseCase(fridge, recipeStorage, groceryList);
    }

    /**
     * Run the use case provided
     */
    public Response run(Command command) {
        return this.usecase.run(command);
    }
}
