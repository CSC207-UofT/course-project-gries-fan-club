package UseCases;

import Entities.Ingredient;
import Entities.Recipe;

import java.util.List;

public interface Response<T> {
    /**
     * Returns the data in the response
     */
    List<T> data();

    /**
     * Add data to the response
     */
    void add(List<T> data);
}





