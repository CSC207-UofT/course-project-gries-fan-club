package Controllers;

import Storages.IngredientStorage;
import Storages.RecipeStorage;
import UseCases.Command;
import UseCases.CommandImpl;
import UseCases.MatcherUseCase;

import java.util.List;

public class MatcherController {

    /** Return the top recipes based on the fridge
     * @param fridge The fridge
     * @param recipes The recipe storage to search
     */
    public List<String> matchFridgeWithRecipes(IngredientStorage fridge, RecipeStorage recipes, Integer numberOfRecipes) {
        MatcherUseCase useCase = new MatcherUseCase(fridge, recipes);
        Command command = new CommandImpl();
        command.put("Fridge", fridge.ingredientString());
        command.put("recipeNumber", numberOfRecipes.toString());
        return useCase.run(command).get("Matched");
    }
}
