package UseCases;

import Commands.Command;
import Entities.Implementations.IngredientImpl;
import Entities.Ingredient;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeStorageImpl;

public class FridgeUseCase implements UseCase {
    IngredientImpl ingredient;
    IngredientStorageImpl fridge;

    /**
     *Constructor
     */
    public FridgeUseCase(IngredientImpl ingredient, IngredientStorageImpl fridge ){
        this.ingredient = ingredient;
        this.fridge = fridge;

    }

    @Override
    public ResponseImpl run(Command command) {
        return null;
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
