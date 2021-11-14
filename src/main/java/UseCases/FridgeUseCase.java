package UseCases;

import Commands.Command;
import Entities.Implementations.IngredientImpl;
import Entities.Ingredient;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeStorageImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FridgeUseCase implements UseCase {
    IngredientImpl ingredient;
    IngredientStorageImpl ingredientStorage;

    /**
     *Constructor
     */
    public FridgeUseCase(IngredientImpl ingredient, IngredientStorageImpl fridge ){
        this.ingredientStorage = fridge;

    }

    @Override
    public ResponseImpl run(Command command) {
        // checks if the user is using addToFridge command (non-empty)
        if (!Objects.equals(command.get("addtofridge"), "")){
        String newString  = command.get("addtofridge");

        List<String> stringsOfIngredients = new ArrayList<>(Arrays.asList(newString.split(",")));
        for (String ingredientString : stringsOfIngredients){
            this.fridge.add(this.ingredientStorage.findByName(ingredientString));
        }
    }
}

    public IngredientStorageImpl addToFridge(Command command){
        fridge.add(ingredient);
        return fridge;
    }

    public IngredientStorageImpl removeFromFridge(Command command) {
        fridge.remove(ingredient);
        return fridge;
    }


}
