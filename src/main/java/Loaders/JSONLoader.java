package main.java.Loaders;

import main.java.DataEntities.Recipe;

import java.util.Collections;
import java.util.Iterator;

public class JSONLoader implements RecipeLoader {

    @Override
    public Iterator<Recipe> iterator() {
        return Collections.emptyIterator();
    }
}
