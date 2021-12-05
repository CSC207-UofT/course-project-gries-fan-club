package Entities.Implementations;

import Entities.Entity;
import Entities.Reference.Reference;

import java.util.UUID;

/**
 * This is a facade over a referenced entity to allow for seamless usage of the
 * underlying implementation.
 *
 * To utilise this class, extend it with the type of entity you want to reference.
 * As well, it should implement that entity's interface and route methods to
 * the underlying entity.
 *
 * @param <T> The type of entity this is tied to.
 */
public abstract class ReferencedEntity<T extends Entity> implements Entity {
	protected final Reference<T> entityReference;

	public ReferencedEntity(Reference<T> entityReference) {
		this.entityReference = entityReference;
	}

	@Override
	public UUID id() {
		return this.entityReference.id();
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
		return this.id().compareTo(other.id());
	}

}
