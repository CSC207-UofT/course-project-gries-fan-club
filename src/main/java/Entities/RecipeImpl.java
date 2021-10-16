package Entities;

import EntityInterfaces.Item;
import EntityInterfaces.Recipe;

import java.util.List;

public class RecipeImpl implements Recipe {
    private List<Item> items;
    private String name;
    private String description;
    private String instructions;

    /** Implement a RecipeImpl, giving the name of the recipe, the description
     * of the recipe, the instructions to make the recipe, and the items needed.
     * @param name          The name of the recipe
     * @param description   The description of the recipe
     * @param instructions  The instructions to make this recipe
     * @param items         The items required to make this recipe
     */
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
