package main.java.Entities;

import main.java.EntityInterfaces.RecipeImpl;

import java.util.List;

public class Recipe implements RecipeImpl {
    List<Item> items;

    Recipe(List<Item> items) {
        this.items = items;
    }

}
