package main.java.DataEntities;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractIngredient implements Ingredient {

    private final String name;

    private List<Tag> tags = new ArrayList<Tag>();

    AbstractIngredient(String name) {
        this.name = name;
    }

    AbstractIngredient(String name, List<Tag> tags) {
        this(name);

        this.tags = tags;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public List<Tag> tags() {
        return this.tags;
    }

    @Override
    public boolean has(Tag tag) {
        for (Tag currentTag : this.tags) {
            if (currentTag.name().equals(tag.name())) {
                return true;
            }
        }
        return false;
    }

}
