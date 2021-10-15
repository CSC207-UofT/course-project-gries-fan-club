package EntityInterfaces;

public interface Item {

    /**
     * Ingredient of the item
     **/
    Ingredient ingredient();

    /**
     * Quantity of item
     **/
    int quantity();

    /**
     * Is the item optional?
     **/
    Boolean optional();
}
