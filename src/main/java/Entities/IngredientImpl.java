package Entities;

import EntityInterfaces.Ingredient;
import EntityInterfaces.Tag;

import java.util.List;

public class IngredientImpl implements Ingredient {
    private String name;
    private List<Tag> tags;

    /** Implements an IngredientImpl with the given name and list of tags
     * @param name      The name of the ingredient
     * @param tags      The tags associated with the ingredient
     */
    public IngredientImpl(String name, List<Tag> tags) {
        this.name = name;
        this.tags = tags;
    }

    @Override
    public List<Tag> tags() {
        return this.tags;
    }

    @Override
    public boolean has(Tag tag) {
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

    @Override
    public String toString() {
        return "IngredientImpl{\n" +
                "\tname='" + name + "',\n" +
                "\ttags=" + tags +
                "\n}";
    }
}
