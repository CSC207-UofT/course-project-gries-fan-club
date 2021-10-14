package main.java.EntityInterfaces;

import main.java.Entities.TagImpl;
import java.util.List;

public interface Ingredient {
    List<TagImpl> tags();
    Boolean has(Tag tag);
    String name();
}
