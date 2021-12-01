package UseCases;

import Commands.Implementations.CommandImpl;
import Entities.Recipe;
import Entities.Tag;
import Storages.RecipeStorage;
import Storages.TagStorage;

// Imports for Java.util
import java.util.*;

public class CookbookUseCase {
    /**
     * The cookbook displays recipes and shows recipes based on tags inputed into command
     */
    final RecipeStorage recipeStorage;
    final TagStorage tagStorage;

    public CookbookUseCase(RecipeStorage recipes, TagStorage tags) {
        this.recipeStorage = recipes;
        this.tagStorage = tags;
    }

    /**
     * Return all recipes if FindAllRecipes provided in command
     * Return recipes containing none of the tags given if FindRecipesByTags provided in command
     * @param command
     * @return RecipeResponseImpl containing a list of recipes found
     */
    public RecipeResponseImpl run(CommandImpl command) {

        if (command.containsKey("FindAllRecipes")) {
            List<Recipe> recipesMatched = new ArrayList<>(this.recipeStorage.recipes());
            return new RecipeResponseImpl(recipesMatched);
        }

        if (command.containsKey("FindRecipesByTags")) {
            List<Tag> tagList = new ArrayList<>();

            // Extract all the tags from the command
            String keyValues = command.get("FindRecipesByTags");
            List<String> stringsOfTags = new ArrayList<>(Arrays.asList(keyValues.split(",")));

            for (String tagString : stringsOfTags) {
                Collection<Tag> foundTags = this.tagStorage.findByName(tagString);
                // Tag found
                if (foundTags.size() > 0) {
                    // return the first element of the found tags
                    tagList.add(foundTags.iterator().next());
                }
            }
            List<Recipe> recipesMatched = new ArrayList<>(this.recipeStorage.containsNoneOf(tagList));
            return new RecipeResponseImpl(recipesMatched);
        }

        // If none of the commands were provided, then return empty list of recipes.
        return new RecipeResponseImpl(Collections.emptyList());
    }
}
