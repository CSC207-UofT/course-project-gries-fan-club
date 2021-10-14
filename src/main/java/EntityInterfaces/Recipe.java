package main.java.EntityInterfaces;
import main.java.Entities.ItemImpl;
import main.java.EntityInterfaces.Item;
import java.util.List;

public interface Recipe {
    List<ItemImpl> items();
    String name();
    String description();
    String instructions();
}
