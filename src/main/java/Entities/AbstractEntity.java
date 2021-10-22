package Entities;
import java.util.UUID;
import main.java.EntityInterfaces.Entity;

public abstract class AbstractEntity implements Entity {
    private final UUID id;

    /**
     * Constructor that takes in string id, converts to UUID and assigns to the entity
     * @param id String that represents the UUID of the entity
     */
    public AbstractEntity(String id) {
        // Convert string representation of the id to UUID and set the entity's id to it
         this.id = UUID.fromString(id);
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
