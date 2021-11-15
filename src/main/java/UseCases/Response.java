package UseCases;

import Entities.Ingredient;
import Entities.Recipe;

import java.util.List;

// Mock Response interface for use case purpose
public interface Response {
    List<Recipe> returnRecipes();
    List<Ingredient> returnIngredients();
}
