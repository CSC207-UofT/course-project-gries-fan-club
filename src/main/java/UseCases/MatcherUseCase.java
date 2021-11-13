package UseCases;

import Commands.Command;
import Entities.Recipe;
import Matchers.Matcher;
import Storages.Implementations.RecipeStorageImpl;
import Storages.IngredientStorage;
import Storages.RecipeStorage;
import Storages.Storage;

import java.util.List;

public class MatcherUseCase implements UseCase {
    IngredientStorage ingredientStorage;
    RecipeStorage recipeStorage;

    /** Constructor
     */
    public MatcherUseCase(IngredientStorage ingredients, RecipeStorage recipes) {
        this.recipeStorage = recipes;
        this.ingredientStorage = ingredients;
    }

    public Response run(Command command) {

    }

}

