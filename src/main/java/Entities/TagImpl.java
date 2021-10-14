package main.java.Entities;
import main.java.EntityInterfaces.Tag;

public class TagImpl implements Tag {
    private String name;

    public TagImpl(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
