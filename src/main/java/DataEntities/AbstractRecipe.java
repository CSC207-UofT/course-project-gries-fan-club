package main.java.DataEntities;

import java.util.List;

public abstract class AbstractRecipe implements Recipe {

    @Override
    public int id() {
        return 0;
    }

    @Override
    public List<RecipeItem> items() {
        return null;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public List<String> instructions() {
        return null;
    }

    @Override
    public boolean has(Tag tag) {
        return false;
    }

}
