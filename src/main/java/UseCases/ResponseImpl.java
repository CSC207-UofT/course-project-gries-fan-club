package UseCases;

import Entities.Ingredient;
import Entities.Recipe;

import java.util.List;

public class ResponseImpl<T> {
    final List<T> data;

    /**
     * Constructor that takes in recipes, and
     * @param data containining data needed to be stored (in a list)
     */
    public ResponseImpl(List<T> data) {
        this.data = data;
    }

    /**
     * Returns the data in the response
     * @return
     */
    public List<T> data() {
        return this.data;
    }
}
