package UseCases;

import Entities.Ingredient;
import Entities.Tag;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface Fridge {
    /**
     * Add the ingredient into the fridge of other ingredients
     * @param ingredientID ingredient entity that is being added
     */
    void add(UUID ingredientID);

    /**
     * Return all of the ingredient id's in a list
     */
    public List<UUID> allIngredientsByID();

}