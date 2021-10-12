package main.java.Entities;

public class Tag implements Tag {
    private String name;

    Tag(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
