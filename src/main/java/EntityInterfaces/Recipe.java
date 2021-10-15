package EntityInterfaces;

import java.util.List;

public interface Recipe {
    List<Item> items();
    String name();
    String description();
    String instructions();
}
