package main.java.Entities;

import java.util.List;

public class Recipe implements main.java.EntityInterfaces.Recipe {
    List<Item> items;

    Recipe(List<Item> items) {
        this.items = items;
    }

}
