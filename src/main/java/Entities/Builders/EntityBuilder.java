package Entities.Builders;

import Entities.Entity;
import Entities.Exceptions.InvalidRowShape;
import Loaders.Loader;
import Loaders.Row;
import Storages.Storage;

import java.util.Collection;

/**
 * Defines a basic interface for building entities from rows.
 *
 * @param <T> The type of entity this builds.
 */
public interface EntityBuilder<T extends Entity> {

	/**
	 * Creates an entity from a given row.
	 *
	 * @param row The row representing the entity
	 * @return A constructed entity
	 * @throws InvalidRowShape If the provided row is invalid for the entity to
	 *                         be constructed.
	 */
	T loadEntity(Row row) throws InvalidRowShape;

	/**
	 * The type of entity this builder creates.
	 *
	 * @return The name as a string
	 */
	String type();

	/**
	 * Attempts to load all entities from a loader.
	 *
	 * If a row is invalid no entity will be created and the row will be ignored.
	 *
	 * @param loader The loader to load from
	 * @return All loaded entities
	 */
	Collection<T> loadFrom(Loader loader);

	/**
	 * Adds all entities from a loader into a given storage.
	 *
	 * @param storage The storage to fill
	 * @param loader  The loader to pull from
	 */
	void addTo(Storage<T> storage, Loader loader);
}
