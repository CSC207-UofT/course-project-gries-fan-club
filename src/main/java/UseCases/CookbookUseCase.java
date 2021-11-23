package UseCases;

import Commands.Implementations.CommandImpl;
import Entities.Recipe;
import Entities.Tag;
import Storages.Implementations.RecipeStorageImpl;
import Storages.Implementations.TagStorageImpl;

import java.util.*;

public class CookbookUseCase {
    /**
     * The cookbook displays recipes and shows recipes based on tags inputed into command
     */
    final RecipeStorageImpl recipeStorage;
    final TagStorageImpl tagStorage;

    public CookbookUseCase(RecipeStorageImpl recipes, TagStorageImpl tags) {
        this.recipeStorage = recipes;
        this.tagStorage = tags;
    }

    public RecipeResponseImpl run(CommandImpl command) {
        List<Recipe> recipesMatched = new ArrayList<>();

        if (!Objects.equals(command.get("FindAllRecipes"), "")) {
            recipesMatched = new ArrayList<>(this.recipeStorage.recipes());

        // If the command FindRecipesByTags was run with given tag
        // This command allows us to find all the recipes that do not contain the given tags
        } else if (!Objects.equals(command.get("FindRecipesByTags"), "")) {
            List<Tag> tagList = new ArrayList<>();

            // Extract all the tags from the command
            String newString = command.get("FindRecipesByTags");
            List<String> stringsOfTags = new ArrayList<>(Arrays.asList(newString.split(",")));

            for (String tagString : stringsOfTags) {
                Collection<Tag> temp = this.tagStorage.findByName(tagString);
                // Tag found
                if (temp.size() > 0) {
                    tagList.add(temp.iterator().next());
                }
            }

            recipesMatched = new ArrayList<>(this.recipeStorage.findByOppositeTags(tagList));
        }
        return new RecipeResponseImpl(recipesMatched);
    }
}

