package main.java.Entities;
import main.java.Entities.TagImpl;
import java.util.List;
import main.java.EntityInterfaces.Tag;
import main.java.EntityInterfaces.Ingredient;

public class IngredientImpl implements Ingredient {
    private String name;
    private List<TagImpl> tags;

    public IngredientImpl(String name, List<TagImpl> tags) {
        this.name = name;
        this.tags = tags;
    }

    @Override
    public List<TagImpl> tags() {
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
