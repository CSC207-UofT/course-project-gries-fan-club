package main.java.EntityInterfaces;

import main.java.Entities.Tag;
import java.util.List;

public interface IngredientImpl {
    List<Tag> tags();
    Boolean has(Tag tag);
    String name();
}
