package Storages;

import Entities.Tag;

import java.util.Collection;

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
