package Storages;

import EntityInterfaces.Recipe;

import java.util.List;

public class RecipeStorage {
    List<Recipe> recipes;

    public RecipeStorage(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
