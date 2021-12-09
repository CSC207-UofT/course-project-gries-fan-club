package UseCases;

import Entities.Ingredient;
import Entities.Recipe;
import Matchers.Implementations.IngredientMatcher;
import Storages.Implementations.IngredientStorageImpl;
import Storages.IngredientStorage;
import Storages.RecipeStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MatcherUseCase implements UseCase {
    final IngredientStorage ingredientStorage;
    final RecipeStorage recipeStorage;

    public MatcherUseCase(IngredientStorage ingredients, RecipeStorage recipes) {
        this.recipeStorage = recipes;
        this.ingredientStorage = ingredients;
    }

    @Override
    public Response run(Command command) {
        List<String> matchedRecipesString = new ArrayList<>();


        // Check if fridge matches the recipe storage
        // First check if fridge is provided
        if (command.containsKey("Fridge")) {
            // set the number of recipes needed to be returned from the matcher
            Integer numberOfItemsMatched = 5;
            if (command.containsKey("recipeNumber")) {
                numberOfItemsMatched = Integer.valueOf(command.get("recipeNumber"));
            }

            // get fridge as ingredient storage
            IngredientStorage fridge = getFridgeStorage(command);

            // Turn fridge.ingredients from collection to a list
            List<Ingredient> allFridgeIngredients = new ArrayList<>(fridge.ingredients());
            IngredientMatcher matcher = new IngredientMatcher(allFridgeIngredients);
            List<Recipe> recipesMatched = new ArrayList<>();
            recipesMatched = matcher.returnRecipesMatched(this.recipeStorage, numberOfItemsMatched);
            for( Recipe recipe: recipesMatched){
                matchedRecipesString.add(recipe.name());
            }
            Response response = new ResponseImpl("", true);
            response.put("Matched", matchedRecipesString);
            return response;
        }
        return new ResponseImpl("", false);
        }

    /** Takes in command, returns an ingredient storage of the fridge
      * @param command Command
     * @return IngredientStorageImpl that corresponds to the fridge
     */
    public IngredientStorage getFridgeStorage(Command command) {
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
