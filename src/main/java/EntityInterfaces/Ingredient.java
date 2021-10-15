package EntityInterfaces;

import java.util.List;

public interface Ingredient {
    /**
     * List of tags for the ingredient
     **/
    List<Tag> tags();

    /**
     * Does the ingredient have said tag?
     **/
    Boolean has(Tag tag);

    /**
     * Ingredient name.
     **/
    String name();
}
