package main.java.EntityInterfaces;

public interface Item {
    Ingredient ingredient();
    int quantity();
    Boolean optional(Boolean value);
}
