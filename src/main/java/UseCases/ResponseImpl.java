package UseCases;

import Entities.Recipe;

import java.util.List;

public class ResponseImpl {
    List<Recipe> recipes;
    public ResponseImpl(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> recipes() {
        return this.recipes;
    }
}
