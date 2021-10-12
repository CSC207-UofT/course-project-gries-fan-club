package main.java.Entities;

import java.util.List;

public class Ingredient implements main.java.EntityInterfaces.Ingredient {
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
        return null;
    }

    @Override
    public String name() {
        return this.name;
    }

}
