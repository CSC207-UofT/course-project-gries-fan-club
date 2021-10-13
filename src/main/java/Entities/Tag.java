package main.java.Entities;

import main.java.EntityInterfaces.TagImpl;

public class Tag implements TagImpl {
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
