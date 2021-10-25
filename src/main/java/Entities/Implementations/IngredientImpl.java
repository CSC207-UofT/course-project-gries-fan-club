package Entities.Implementations;

import Entities.Ingredient;
import Entities.Tag;

import java.util.List;
import java.util.UUID;

public class IngredientImpl extends AbstractEntity implements Ingredient {
    private String name;
    private List<Tag> tags;

    /** Implements an IngredientImpl with the given name and list of tags
     * @param id        The UUID of the Ingredient
     * @param name      The name of the ingredient
     * @param tags      The tags associated with the ingredient
     */
    public IngredientImpl(UUID id, String name, List<Tag> tags) {
        super(id);
        this.name = name;
        this.tags = tags;
    }

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
