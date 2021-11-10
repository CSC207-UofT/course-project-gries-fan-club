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

    /**
     * Compares equality of entities via their ID.
     *
     * This method does not care about whether entities refer to the same
     * object, instead it is focused on the data it symbolizes.
     * As such, entities only need to share an ID to be considered the same.
     *
     * @param other The object to compare to.
     *
     * @return Whether these objects refer to the same entity.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        AbstractEntity otherEntity = (AbstractEntity) other;
        return this.id.equals(otherEntity.id());
    }

    /**
     * Here is a natural ordering for entities which is via their ID.
     *
     * @param other The other entity to compare to.
     *
     * @return The comparison of the entities IDs.
     */
    @Override
    public int compareTo(Entity other) {
        return this.id.compareTo(other.id());
    }
}
