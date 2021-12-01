package UseCases;

import Commands.Implementations.CommandImpl;
import Entities.Ingredient;
import Entities.Recipe;
import Matchers.Implementations.IngredientMatcher;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeStorageImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MatcherUseCase implements UseCase {
    final IngredientStorageImpl ingredientStorage;
    final RecipeStorageImpl recipeStorage;

    /** Constructor
     */
    public MatcherUseCase(IngredientStorageImpl ingredients, RecipeStorageImpl recipes) {
        this.recipeStorage = recipes;
        this.ingredientStorage = ingredients;
    }

    public RecipeResponseImpl run(CommandImpl command) {
        List<Recipe> recipesMatched = new ArrayList<>();

        // Check if fridge matches the recipe storage
        // First check if fridge is provided
        if (command.containsKey("Fridge")) {
            // get fridge as ingredient storage
            IngredientStorageImpl fridge = getFridgeStorage(command);

            // pass in the fridge
            List<Ingredient> allFridgeIngredients = new ArrayList<>(fridge.ingredients());
            IngredientMatcher matcher = new IngredientMatcher(allFridgeIngredients);

            recipesMatched = matcher.return10RecipesMatched(this.recipeStorage);
        }
        return new RecipeResponseImpl(recipesMatched);
        }

    /** Takes in command, returns an ingredient storage of the fridge
      * @param command Command
     * @return IngredientStorageImpl that corresponds to the fridge
     */
    public IngredientStorageImpl getFridgeStorage(CommandImpl command) {
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
