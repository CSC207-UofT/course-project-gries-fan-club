package UseCases;

import Entities.Ingredient;
import Entities.Recipe;

import java.util.List;

public class ResponseImpl<T> {
    List<T> data;

    /**
     * Constructor that takes in recipes, and
     * @param data containining data needed to be stored (in a list)
     */
    public ResponseImpl(List<T> data) {
        this.add(data);
    }

    /**
     * Returns the data in the response
     * @return
     */
    public List<T> data() {
        return this.data;
    }

    /**
     * Adds data into the response
     */
    public void add(List<T> data) {
        this.data = data;
    }

}
