package EntityInterfaces;

import java.util.List;

public interface Ingredient {
    List<Tag> tags();
    Boolean has(Tag tag);
    String name();
}
