package main.java.Entities;

import main.java.Entities.ItemImpl;
import java.util.List;

public class RecipeImpl implements main.java.EntityInterfaces.Recipe {
    private List<ItemImpl> items;
    private String name;
    private String description;
    private String instructions;

    public RecipeImpl(String name, String description, String instructions, List<ItemImpl> items) {
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.items = items;
    }

    @Override
    public List<ItemImpl> items() {
        return this.items;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public String instructions() {
        return this.instructions;
    }
}
