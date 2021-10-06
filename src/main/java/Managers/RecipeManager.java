package main.java.Managers;

import main.java.DataEntities.Recipe;
import main.java.Loaders.RecipeLoader;

import java.util.List;

public interface RecipeManager {

    public void loadFrom(RecipeLoader loader);

    public List<Recipe> recipes();

    public Recipe find(Recipe recipe);

}
