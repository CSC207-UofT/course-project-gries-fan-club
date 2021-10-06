package main.java.DataEntities;

import java.util.List;

public interface Ingredient {

    public String name();

    public List<Tag> tags();

    public boolean has(Tag tag);

}
