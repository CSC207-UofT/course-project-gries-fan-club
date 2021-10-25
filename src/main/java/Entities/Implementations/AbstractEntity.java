package Entities.Implementations;
import Entities.Entity;
import java.util.UUID;

public abstract class AbstractEntity implements Entity {
    private final UUID id;

    /**
     * Constructor that takes in string id, converts to UUID and assigns to the entity
     * @param id  the UUID of the entity
     */
    public AbstractEntity(UUID id) {
        // set Entity's id
         this.id = id;
    }

    /**
     * Constructor that takes in no parameters, instead generates a new random id and
     * assigns it to the entity
     */
    public AbstractEntity() {
        // Generate uuid and assign to entity's id
        this.id = UUID.randomUUID();
    }

    /**
     * Returns the entity's id if there is one
     * @return String representation of the Entity's id
     */
    @Override
    public UUID id() {
        return this.id;
    }

}
