package UseCases;

import Commands.Command;
import Commands.Implementations.CommandImpl;
import Storages.Implementations.IngredientStorageImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FridgeUseCase implements UseCase {
    IngredientStorageImpl ingredientStorage;
    IngredientStorageImpl fridge;

    /**
     * Constructor
     */
    public FridgeUseCase(IngredientStorageImpl fridge, IngredientStorageImpl ingredientStorage) {
        this.ingredientStorage = ingredientStorage;
        this.fridge = fridge;

    }

    @Override
    public IngredientStorageResponseImpl run(CommandImpl command) {
        // checks if the user is using addToFridge command (non-empty)
        if (!Objects.equals(command.get("addtofridge"), "") && command.containsKey("addtofridge")) {
            String newString = command.get("addtofridge");

            List<String> stringsOfIngredients = new ArrayList<>(Arrays.asList(newString.split(",")));
            for (String ingredientString : stringsOfIngredients) {
                this.fridge.add(this.ingredientStorage.findByNameExact(ingredientString).iterator().next());
            }
        }
        // checks if the user is using removeFromFridge command (non-empty)
        if (!Objects.equals(command.get("removefromfridge"), "") && command.containsKey("removefromfridge")) {
            String newString = command.get("removefromfridge");

            List<String> stringsOfIngredients = new ArrayList<>(Arrays.asList(newString.split(",")));
            for (String ingredientString : stringsOfIngredients) {
                this.fridge.remove(this.ingredientStorage.findByNameExact(ingredientString).iterator().next());

            }

        }
        return new IngredientStorageResponseImpl(this.fridge);

    }
}
