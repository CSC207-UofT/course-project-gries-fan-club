package UseCases;

import Entities.Implementations.IngredientImpl;
import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Storages.Implementations.IngredientStorageImpl;
import Storages.IngredientStorage;
import Storages.RecipeStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroceryUseCase implements UseCase {
    /**
     * The Grocery aggregates a list of ingredients that you need to buy based off the recipes you want to make. The
     * ingredients in the grocery are ingredients you need to buy.
     */
    IngredientStorage fridge;
    final RecipeStorage recipeStorage;
    IngredientStorage groceryList;

    public GroceryUseCase(IngredientStorage fridge, RecipeStorage recipeStorage, IngredientStorage groceryList) {
        this.fridge = fridge;
        this.recipeStorage = recipeStorage;
        this.groceryList = groceryList;
    }
    /**
     * Return all ingredients needed if listRecipeItems provided in command
     * Return all items in grocery and import to fridge.
     * @param command
     * @return IngredientStorageResponseImpl containing a list of ingredients found
     */

    public Response run(Command command) {
        if (command.containsKey("listRecipeItems")) {
            // Iterating through recipes in recipestorage
            for (Recipe recipe : this.recipeStorage.recipes()) {
                // Iterating through each recipeItem in each recipe
                for (RecipeItem item : recipe.items()) {
                    // adding ingredient in recipe to our list of ingredients
                    if (!(this.fridge.contains(item.ingredient()))) {
                        this.groceryList.add(item.ingredient());
                    }
                }
            }
        }

        if (command.containsKey("importRecipeItems")) {
            // Adding all items currently in grocery to the fridge
            this.fridge.addAll(this.groceryList);
            // List of items added to fridge
            List<Ingredient> importedItems = new ArrayList<>(this.groceryList.ingredients());
            // grocery should now be empty
            this.groceryList = new IngredientStorageImpl();

            // Return the items we are importing to fridge
            return new ResponseImpl(importedItems);
        }
        if (command.containsKey("removeFromGroceryList")) {
            String keyValues = command.get("removeFromGroceryList");

            assert keyValues != null;
            List<String> stringsOfIngredients = new ArrayList<>(Arrays.asList(keyValues.split(",")));

            for (String ingredientString : stringsOfIngredients) {
                // Store current ingredient
                Ingredient currIngredient = this.groceryList.findByNameExact(ingredientString).iterator().next();
                // Adds ingredients (from key values) to fridge
                this.fridge.add(currIngredient);
                // Removes ingredients from groceryList
                this.groceryList.remove(currIngredient);
            }
        }
        // Return the groceryList containing ingredients that need to be bought
        List<Ingredient> groceryIngredientList = new ArrayList<>(this.groceryList.ingredients());
        return new ResponseImpl(groceryIngredientList);
    }

}
