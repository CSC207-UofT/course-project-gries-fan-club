package Storages.Implementations;

import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Tag;
import Matchers.Implementations.TagMatcher;
import Storages.RecipeStorage;
import Storages.TagStorage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TagStorageImpl extends AbstractStorage<Tag> implements TagStorage {

    @Override
    public String type() {
        return "tag";
    }

    @Override
    public Collection<Tag> tags() { return this.entities.values(); }

    @Override
    public Collection<Tag> findByName(String name) {
        //Regexes to be added later
        Collection<Tag> found = new ArrayList<>();
        for (Tag tag : this.tags()) {
            if (tag.name().contains(name))
                found.add(tag);
        }
        return found;
    }

}
