package UseCases;

import Commands.Command;
import Entities.Implementations.IngredientImpl;
import Entities.Ingredient;
import Entities.Recipe;
import Matchers.Implementations.IngredientMatcher;
import Matchers.Implementations.TagMatcher;
import Matchers.Matcher;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeStorageImpl;
import Storages.IngredientStorage;
import Storages.RecipeStorage;
import Storages.Storage;

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

    public ResponseImpl run(Command command) {
        List<Recipe> recipesMatched = new ArrayList<>();

        // Check if fridge matches the recipe storage
        if (!Objects.equals(command.get("Fridge"), "")) {

            // get fridge as ingredient storage
            IngredientStorageImpl fridge = getFridgeStorage(command);

            // pass in the fridge
            IngredientMatcher matcher = new IngredientMatcher((List<Ingredient>) fridge.ingredients());

            recipesMatched = matcher.return10RecipesMatched(this.recipeStorage);
        }
        return new ResponseImpl(recipesMatched);
        }

    /**
      * @param command Command
     * @return IngredientStorageImpl that corresponds to the fridge
     */
    public IngredientStorageImpl getFridgeStorage(Command command) {
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


