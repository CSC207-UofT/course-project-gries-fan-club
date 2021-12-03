package UseCases;

import Commands.Implementations.CommandImpl;
import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Storages.Implementations.IngredientStorageImpl;
import Storages.IngredientStorage;
import Storages.RecipeStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroceryUseCase {
    /**
     * The grocery displays gives all ingredients you currently need to buy.
     */
    IngredientStorage fridge;
    final RecipeStorage recipeStorage;
    IngredientStorage grocery;

    public GroceryUseCase(IngredientStorage fridge, RecipeStorage recipeStorage, IngredientStorage grocery) {
        this.fridge = fridge;
        this.recipeStorage = recipeStorage;
        this.grocery = grocery;
    }

    /**
     * Return all ingredients needed if listRecipeItems provided in command
     * Return all items in grocery and import to fridge.
     * @param command
     * @return IngredientStorageResponseImpl containing a list of ingredients found
     */

    public IngredientStorageResponseImpl run(CommandImpl command) {


        if (command.containsKey("listRecipeItems")) {
            // Empty list initialized, so we can add all ingredients needed for recipes
            List<Ingredient> recipeIngredients = new ArrayList<>();

            // Iterating through recipes in recipestorage
            for (Recipe recipe : this.recipeStorage.recipes()) {
                // Iterating through each recipeItem in each recipe
                for (RecipeItem item : recipe.items()) {
                    // adding ingredient in recipe to our list of ingredients
                    recipeIngredients.add(item.ingredient());
                }
            }

            // Iterating through all ingredients needed for recipes
            for (Ingredient ingredient : recipeIngredients) {
                // If the fridge does not contain a needed ingredient, we add the ingredient to the grocery
                if (!(this.fridge.contains(ingredient))) {
                    // ingredient gets added to grocery
                    this.grocery.add(ingredient);
                }
            }
            return new IngredientStorageResponseImpl(this.grocery);
        }

        if (command.containsKey("importRecipeItems")) {
            // Adding all items currently in grocery to the fridge
            this.fridge.addAll(this.grocery);
            // Grocery list should get emptied now
            this.grocery = new IngredientStorageImpl();
            // Return the fridge that contains the ingredients added from grocery
        }
        return new IngredientStorageResponseImpl(this.grocery);
    }

}
