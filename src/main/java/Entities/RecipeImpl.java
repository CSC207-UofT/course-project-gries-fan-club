package Entities;

import EntityInterfaces.RecipeItem;
import EntityInterfaces.Recipe;

import java.util.List;

public class RecipeImpl implements Recipe {
    private List<RecipeItem> recipeItems;
    private String name;
    private String description;
    private String instructions;

    /**
     * Construct a RecipeImpl, giving the name of the recipe, the description
     * of the recipe, the instructions to make the recipe, and the items needed.
     * @param name          The name of the recipe
     * @param description   The description of the recipe
     * @param instructions  The instructions to make this recipe
     * @param recipeItems   The items required to make this recipe
     */
    public RecipeImpl(String name, String description, String instructions, List<RecipeItem> recipeItems) {
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.recipeItems = recipeItems;
    }

    @Override
    public List<RecipeItem> items() {
        return this.recipeItems;
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
