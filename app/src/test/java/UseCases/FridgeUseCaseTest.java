package UseCases;

import Entities.Implementations.IngredientImpl;
import Storages.Implementations.IngredientStorageImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FridgeUseCaseTest {
    @Test
    public void testAddToFridge() {
        IngredientStorageImpl fridge = new IngredientStorageImpl();
        IngredientImpl ingredient1 = new IngredientImpl("oil", Collections.emptyList());
        IngredientImpl ingredient2 = new IngredientImpl("chocolate chips", Collections.emptyList());

        IngredientStorageImpl ingredients = new IngredientStorageImpl();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        Command command = new CommandImpl();
        command.put("addToFridge", "oil,chocolate chips");

        FridgeUseCase useCase = new FridgeUseCase(fridge, ingredients);

        List<String> fridgeList = new ArrayList<>();
        fridgeList.add("oil");
        fridgeList.add("chocolate chips");
        Assertions.assertTrue(useCase.run(command).get("fridge").contains("chocolate chips"));
        Assertions.assertTrue(useCase.run(command).get("fridge").contains("oil"));
    }

    @Test
    public void testRemoveFromFridge() {
        IngredientStorageImpl fridge = new IngredientStorageImpl();
        IngredientImpl ingredient1 = new IngredientImpl("oil", Collections.emptyList());
        IngredientImpl ingredient2 = new IngredientImpl("chocolate chips", Collections.emptyList());

        fridge.add(ingredient1);
        fridge.add(ingredient2);

        IngredientStorageImpl ingredients = new IngredientStorageImpl();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        CommandImpl command = new CommandImpl();
        command.put("removeFromFridge", "oil");

        FridgeUseCase useCase = new FridgeUseCase(fridge, ingredients);

        Assertions.assertFalse(useCase.run(command).get("fridge").contains(ingredient1));
        Assertions.assertTrue(fridge.contains(ingredient2));
    }
}
