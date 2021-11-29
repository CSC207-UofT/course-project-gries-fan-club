package UseCases;

import Entities.Ingredient;
import Entities.Recipe;

import java.util.List;

public interface Response {
    /**
     * Returns the data in the response
     */
    List<Recipe> data();
}





