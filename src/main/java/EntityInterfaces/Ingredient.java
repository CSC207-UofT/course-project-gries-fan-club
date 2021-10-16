package EntityInterfaces;

import java.util.List;

public interface Ingredient {
    /**
     * Return the List of Tags for this ingredient
     * @return The list of tags for the ingredient
     **/
    List<Tag> tags();

    /**
     * Return whether the ingredient has the given tag
     * @return Does the ingredient have the given tag?
     **/
    Boolean has(Tag tag);

    /**
     * Return the ingredients name
     * @return the Ingredient name.
     **/
    String name();
}
