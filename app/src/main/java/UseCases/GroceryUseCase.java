package UseCases;

import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
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
    IngredientStorage groceryList;
    IngredientStorage ingredientStorage;

    public GroceryUseCase(IngredientStorage fridge, IngredientStorage groceryList, IngredientStorage ingredientStorage) {
        this.fridge = fridge;
        this.groceryList = groceryList;
        this.ingredientStorage = ingredientStorage;
    }
    /**
     * Return all ingredients needed if listRecipeItems provided in command
     * Return all items in grocery and import to fridge.
     * @param command The command to execute
     * @return IngredientStorageResponseImpl containing a list of ingredients found
     */

    public Response run(Command command) {
      List<String> ingredients = new ArrayList<>();
        if (command.containsKey("addToList")) {
            // Iterating through recipes in ingredientstorage
            for (Ingredient item : this.ingredientStorage) {
                    // adding ingredient in recipe to our list of ingredients
                    if (!(this.fridge.contains(item))) {
                        this.groceryList.add(item);
                    }

            }
          for( Ingredient ingredient: this.groceryList){
              ingredients.add(ingredient.name());
          }
            Response response = new ResponseImpl("", true);
          response.put("Grocery", ingredients);
          return response;
        }

        if (command.containsKey("importRecipeItems")) {
            // Adding all items currently in grocery to the fridge
            int ingredientsAdded = this.groceryList.size();
            this.fridge.addAll(this.groceryList);

            // grocery should now be empty

            // Return the items we are importing to fridge

                for( Ingredient ingredient: this.groceryList){
                    ingredients.add(ingredient.name());
                }
                Response response = new ResponseImpl("", true);
                response.put("Grocery", ingredients);
                this.groceryList.clear();
                return response;
        }
        if (command.containsKey("removeFromGroceryList")) {
            String keyValues = command.get("removeFromGroceryList");

            assert keyValues != null;
            List<String> stringsOfIngredients = new ArrayList<>(Arrays.asList(keyValues.split(",")));

            for (String ingredientString : stringsOfIngredients) {
                // Store current ingredient
                Ingredient currIngredient = this.ingredientStorage.findByNameExact(ingredientString).iterator().next();
                // Adds ingredients (from key values) to fridge
                this.fridge.add(currIngredient);
                // Removes ingredients from groceryList
                this.groceryList.remove(currIngredient);
            }
            for( Ingredient ingredient: this.groceryList){
                ingredients.add(ingredient.name());
            }
            Response response = new ResponseImpl("", true);
            response.put("Grocery", ingredients);
            return response;
        }

        return new ResponseImpl("", false);
    }

}
