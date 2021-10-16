package Entities;
import EntityInterfaces.Tag;

public class TagImpl implements Tag {
    private String name;

    /** Implement a TagImpl, giving the name of the tag.
     * @param tag  The name of the tag
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
