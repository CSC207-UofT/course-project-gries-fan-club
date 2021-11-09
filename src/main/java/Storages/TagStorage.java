package Storages;

import Entities.Entity;
import Entities.Ingredient;
import Entities.Recipe;
import Entities.Tag;

import java.util.Collection;
import java.util.List;

public interface TagStorage extends Storage<Tag> {

    /**
     * All the tags stored within.
     *
     * @return A collection of recipes
     */
    Collection<Tag> tags();

    /**
     * Finds tag(s) that match a given name.
     * Regular expressions can also be provided.
     *
     * @param name The name or regex to match
     *
     * @return All matched recipes
     */
    Collection<Tag> findByName(String name);

}
