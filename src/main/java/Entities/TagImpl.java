package Entities;
import EntityInterfaces.Tag;

import java.util.UUID;

public class TagImpl extends AbstractEntity  implements Tag {
    private final String name;

    /** Implement a TagImpl, giving the name of the tag.
     * This construtor includes an id
     * @param id    UUID of the tag
     * @param name  The name of the tag
     */
    public TagImpl(UUID id, String name) {
        super(id);
        this.name = name;
    }

    /** Implement a TagImpl, giving the name of the tag.
     * @param name  The name of the tag
     */
    public TagImpl(String name) {
        this.name = name;
    }

    /** Returns the name of the tag
     * @return the name of the tag
     */
    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object object) {
        Tag other = (Tag) object;
        return this.name.equals(other.name());
    }

    @Override
    public String toString() {
        return name;
    }
}
