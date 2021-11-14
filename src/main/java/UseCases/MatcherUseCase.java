package UseCases;

import Commands.Command;
import Entities.Recipe;
import Matchers.Implementations.TagMatcher;
import Matchers.Matcher;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeStorageImpl;
import Storages.IngredientStorage;
import Storages.RecipeStorage;
import Storages.Storage;

import java.util.List;

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
        List<Recipe> recipesMatched;

        if command.get("Tags") {
            TagMatcher matcher = new TagMatcher(command.get("Tags"));
            recipesMatched = matcher.allMatches(this.recipeStorage);
        }
        return new ResponseImpl(recipesMatched);
        }

}

