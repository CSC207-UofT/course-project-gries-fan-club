
package UseCases;

import Entities.Ingredient;
import Entities.Recipe;

import java.util.List;


public class RecipeResponseImpl extends AbstractResponse {
    final List<Recipe> recipes;
    public RecipeResponseImpl(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> recipes() {
        return this.recipes;
    }

    @Override
    public List<Recipe> returnRecipes() {
        return null;
    }

    @Override
    public List<Ingredient> returnIngredients() {
        return null;
    }
}
