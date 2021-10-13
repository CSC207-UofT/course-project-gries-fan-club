package main.java.EntityInterfaces;
import main.java.Entities.Recipe;
import main.java.Entities.Item;
import java.util.List;

public interface RecipeImpl {
    List<Item> items();
    String name();
    String description();
    String instructions();
}
