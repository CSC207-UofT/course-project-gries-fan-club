package UseCases;

import Commands.Command;
import Commands.Implementations.CommandImpl;
import Entities.Implementations.IngredientImpl;
import Entities.Ingredient;
import Entities.Recipe;
import Matchers.Implementations.IngredientMatcher;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeStorageImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MatcherUseCase implements UseCase {
    IngredientStorageImpl ingredientStorage;
    RecipeStorageImpl recipeStorage;

    /** Constructor
     */
    public MatcherUseCase(IngredientStorageImpl ingredients, RecipeStorageImpl recipes) {
        this.recipeStorage = recipes;
        this.ingredientStorage = ingredients;
    }

    public RecipeResponseImpl run(CommandImpl command) {
        List<Recipe> recipesMatched = new ArrayList<>();

        // Check if fridge matches the recipe storage
        if (!Objects.equals(command.get("Fridge"), "")) {

            // get fridge as ingredient storage
            IngredientStorageImpl fridge = getFridgeStorage(command);

            // pass in the fridge
            IngredientMatcher matcher = new IngredientMatcher((List<Ingredient>) fridge.ingredients());

            recipesMatched = matcher.return10RecipesMatched(this.recipeStorage);
        }
        return new RecipeResponseImpl(recipesMatched);
        }

    /**
      * @param command Command
     * @return IngredientStorageImpl that corresponds to the fridge
     */
    public IngredientStorageImpl getFridgeStorage(CommandImpl command) {
        IngredientStorageImpl fridge = new IngredientStorageImpl();
        String newString = command.get("Fridge");
        List<String> stringsOfIngredients = new ArrayList<>(Arrays.asList(newString.split(",")));

        for (String ingredientString : stringsOfIngredients) {
            IngredientImpl ingredient = (IngredientImpl) this.ingredientStorage.findByName(ingredientString);
            fridge.add(ingredient);
        }

        return fridge;
    }
}


