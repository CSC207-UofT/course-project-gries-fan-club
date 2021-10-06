package main.java.DataEntities;

import java.util.List;

public interface Fridge {

    public List<Ingredient> contents();

    public void add(Ingredient ingredient);

    public void remove(Ingredient ingredient);

    public void has(Ingredient ingredient);

}
