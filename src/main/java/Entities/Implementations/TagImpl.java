package Entities.Implementations;
import Entities.Tag;

import java.util.UUID;

public class TagImpl extends AbstractEntity  implements Tag {
    private final String name;

    /**
     * Implement a TagImpl, giving the name of the tag.
     *
     * @param id    UUID of the tag
     * @param name  The name of the tag
     */
    public TagImpl(UUID id, String name) {
        super(id);
        this.name = name;
    }

    /** Implement a TagImpl, giving the name of the tag.
     *
     * @param name  The name of the tag
     */
    public TagImpl(String name) {
        this.name = name;
    }

    /** Returns the name of the tag
     *
     * @return a string representing the name of the tag
     */
    public String name() {
        return this.name;
    }

    /** Return whether or not a given tag is equal to this tag
     *
     * @param object Object that represents a tag
     *
     * @return a boolean representing if they are equal
     */
    @Override
    public boolean equals(Object object) {
        Tag other = (Tag) object;
        return this.name.equals(other.name());
    }

    /** Override the toString method to return the name of the tag
     *
     * @return a string containing the name of the tag
     */
    @Override
    public String toString() {
        return name;
    }
}
