package UseCases;

import Entities.Ingredient;
import Entities.Recipe;
import Matchers.Implementations.IngredientMatcher;
import Storages.Implementations.IngredientStorageImpl;
import Storages.IngredientStorage;
import Storages.RecipeStorage;

import java.util.*;

public class MatcherUseCase implements UseCase {
    final IngredientStorage ingredientStorage;
    final RecipeStorage recipeStorage;

    public MatcherUseCase(IngredientStorage ingredients, RecipeStorage recipes) {
        this.recipeStorage = recipes;
        this.ingredientStorage = ingredients;
    }

    public Response <Recipe> run(CommandImpl command) {
        List<Recipe> recipesMatched = new ArrayList<>();

        // Check if fridge matches the recipe storage
        // First check if fridge is provided
        if (command.containsKey("Fridge")) {
            // get fridge as ingredient storage
            IngredientStorage fridge = getFridgeStorage(command);

            // Turn fridge.ingredients from collection to a list
            List<Ingredient> allFridgeIngredients = new ArrayList<>(fridge.ingredients());
            IngredientMatcher matcher = new IngredientMatcher(allFridgeIngredients);
            recipesMatched = matcher.return10RecipesMatched(this.recipeStorage);
        }
        return new ResponseImpl(recipesMatched);
        }

    /** Takes in command, returns an ingredient storage of the fridge
      * @param command Command
     * @return IngredientStorageImpl that corresponds to the fridge
     */
    public IngredientStorage getFridgeStorage(CommandImpl command) {
        IngredientStorageImpl fridge = new IngredientStorageImpl();
        String keyValues = command.get("Fridge");
        List<String> stringsOfIngredients = new ArrayList<>(Arrays.asList(keyValues.split(",")));

        for (String ingredientString : stringsOfIngredients) {
            Collection<Ingredient> ingredientList = this.ingredientStorage.findByNameExact(ingredientString);
            // Ingredient found
            if (ingredientList.size() > 0) {
                fridge.add(ingredientList.iterator().next());
            }
        }
        return fridge;
    }
}


