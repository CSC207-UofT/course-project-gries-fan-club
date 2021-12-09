package Controllers;

import Storages.IngredientStorage;
import UseCases.Command;
import UseCases.CommandImpl;
import UseCases.FridgeUseCase;

public class FridgeController {
    /**
     * Provide ingredientNames seperated by commas
     * ex. "carrot,milk,pear,steak"
     */
    public void addToFridge(IngredientStorage fridge, IngredientStorage ingredients, String ingredientNames) {
        FridgeUseCase fridgeUseCase = new FridgeUseCase(fridge, ingredients);
        Command command = new CommandImpl();
        command.put("addToFridge", ingredientNames);
        fridgeUseCase.run(command);
    }

    /**
     * Provide ingredientNames seperated by commas
     * ex. "carrot,milk,pear,steak"
     */
    public void removeFromFridge(IngredientStorage fridge, IngredientStorage ingredients, String ingredientNames) {
        FridgeUseCase fridgeUseCase = new FridgeUseCase(fridge, ingredients);
        Command command = new CommandImpl();
        command.put("removeFromFridge", ingredientNames);
        fridgeUseCase.run(command);
    }

}
