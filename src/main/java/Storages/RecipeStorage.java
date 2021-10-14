package main.java.Storages;
import java.util.List;
import java.util.ArrayList;
import main.java.EntityInterfaces.Recipe;

public class RecipeStorage {
    List<Recipe> recipes;

    public RecipeStorage(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
