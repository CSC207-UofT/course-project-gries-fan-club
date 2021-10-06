package main.java.DataEntities;

import java.util.List;

public interface ShoppingList extends List<Ingredient> {

    public void addTo(Fridge fridge);

}
