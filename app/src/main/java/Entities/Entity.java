package Entities;
import java.util.UUID;

/**
 * A basic entity object.
 *
 * Entities are defined by a unique ID and a type.
 */
public interface Entity extends Comparable<Entity> {

    /**
     * The ID of this entity.
     *
     * @return The ID.
     */
    UUID id();

}
