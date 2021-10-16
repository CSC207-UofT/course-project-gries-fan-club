package EntityInterfaces;

public interface Item {

    /**
     * Return the Ingredient for this Item
     * @return the ingredient for the item
     **/
    Ingredient ingredient();

    /**
     * Return the quantity of this item
     * @return the Quantity of this item
     **/
    int quantity();

    /**
     * Return whether this item is optional
     * @return Is this Item optional
     **/
    Boolean optional();
}
