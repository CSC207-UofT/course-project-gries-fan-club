package Entities;

import EntityInterfaces.Item;
import EntityInterfaces.Recipe;

import java.util.List;

public class RecipeImpl implements Recipe {
    private List<Item> items;
    private String name;
    private String description;
    private String instructions;

    public RecipeImpl(String name, String description, String instructions, List<Item> items) {
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.items = items;
    }

    @Override
    public List<Item> items() {
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
