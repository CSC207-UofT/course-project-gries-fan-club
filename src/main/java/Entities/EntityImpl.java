package main.java.Entities;

import main.java.EntityInterfaces.Entity;

public class EntityImpl implements Entity {
    private int id;

    public EntityImpl(int id) {
        // must set the id here
    }

    public EntityImpl() {
        // Must create the id here because no id passed in parameter
    }
}
