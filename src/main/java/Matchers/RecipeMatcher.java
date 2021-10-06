package main.java.Matchers;

import main.java.DataEntities.Recipe;
import main.java.Managers.RecipeManager;

import java.util.List;

public interface RecipeMatcher {

    public float scoreOf(Recipe recipe);

    public List<Float> scoreOfAll(List<Recipe> recipes);

    public void setManager(RecipeManager manager);

}
