package main.java.Entities;

import main.java.EntityInterfaces.IngredientImpl;

import java.util.List;

public class Ingredient implements IngredientImpl {
    private String name;
    private List<Tag> tags;

    public Ingredient(String name, List<Tag> tags) {
        this.name = name;
        this.tags = tags;
    }

    @Override
    public List<Tag> tags() {
        return this.tags;
    }

    @Override
    public Boolean has(Tag tag) {
        for (Tag item : this.tags) {
            if (tag.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String name() {
        return this.name;
    }

}
