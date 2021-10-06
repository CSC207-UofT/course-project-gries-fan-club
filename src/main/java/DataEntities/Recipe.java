package main.java.DataEntities;

import java.util.List;

public interface Recipe {

    public int id();

    public List<RecipeItem> items();

    public String name();

    public String description();

    public List<String> instructions();

    public boolean has(Tag tag);

}
