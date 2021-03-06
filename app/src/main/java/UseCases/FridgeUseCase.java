package UseCases;

import Entities.Ingredient;
import Storages.IngredientStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FridgeUseCase implements UseCase {
    final IngredientStorage ingredientStorage;
    final IngredientStorage fridge;

    /**
     * Constructor
     */
    public FridgeUseCase(IngredientStorage fridge, IngredientStorage ingredientStorage) {
        this.ingredientStorage = ingredientStorage;
        this.fridge = fridge;
    }

    /**
     * Will either add to fridge or remove from fridge based on what is provided.
     *
     * @param command
     * @return IngredientStorageResponseImpl containing the ingredients of the fridge
     */
    @Override
    public Response run(Command command) {

        // checks if the user is using addToFridge command (non-empty)
        if (command.containsKey("addToFridge")) {
            String keyValues = command.get("addToFridge");

            List<String> stringsOfIngredients = new ArrayList<>(Arrays.asList(keyValues.split(",")));

            for (String ingredientString : stringsOfIngredients) {
                this.fridge.add(this.ingredientStorage.findByNameExact(ingredientString).iterator().next());
            }
        }

        // checks if the user is using removeFromFridge command (non-empty)
        if (command.containsKey("removeFromFridge")) {
            String keyValues = command.get("removeFromFridge");

            List<String> stringsOfIngredients = new ArrayList<>(Arrays.asList(keyValues.split(",")));
            for (String ingredientString : stringsOfIngredients) {
                this.fridge.remove(this.ingredientStorage.findByNameExact(ingredientString).iterator().next());
            }
        }

        List<String> fridgeIngredientList = new ArrayList<>();
        for (Ingredient ingredient : this.fridge.ingredients()) {
            fridgeIngredientList.add(ingredient.name());
        }

        ResponseImpl response = new ResponseImpl("", true);
        response.put("fridge", fridgeIngredientList);
        return response;
    }
}
