package Storages.Implementations;

import Entities.Tag;
import Storages.TagStorage;

import java.util.ArrayList;
import java.util.Collection;

public class TagStorageImpl extends AbstractStorage<Tag> implements TagStorage {

    @Override
    public String type() {
        return "tag";
    }

    @Override
    public Collection<Tag> tags() { return this.entities.values(); }

    @Override
    public Collection<Tag> findByName(String name) {
        Collection<Tag> found = new ArrayList<>();
        for (Tag tag : this.tags()) {
            if (tag.name().contains(name)) {
                found.add(tag);
            }
        }
        return found;
    }

}
