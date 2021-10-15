package Storages;

import EntityInterfaces.Recipe;

import java.util.List;

public class RecipeStorage {
    List<Recipe> recipes;

    public RecipeStorage(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    /**
     * Constructs a RecipeStorage with given list of recipes
     * @param recipes       List of recipes
     **/
}
