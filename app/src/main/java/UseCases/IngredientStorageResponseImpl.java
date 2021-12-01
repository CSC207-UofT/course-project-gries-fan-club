package UseCases;

import Entities.Ingredient;
import Entities.Recipe;

import java.util.Collection;
import java.util.List;

public class IngredientStorageResponseImpl extends AbstractResponse {

    final Collection<Ingredient> ingredients;
    public IngredientStorageResponseImpl(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Collection<Ingredient> ingredients() {
        return this.ingredients;
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