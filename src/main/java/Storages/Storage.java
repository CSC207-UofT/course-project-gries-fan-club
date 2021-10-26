package Storages;

import Entities.Entity;
import Storages.Exceptions.NoSuchEntity;

import java.util.Collection;
import java.util.UUID;

/**
 * Defines a storage for a given type of entity.
 *
 * @param <T> The class of entity to store.
 */
public interface Storage<T extends Entity> extends Collection<T> {

	/**
	 * Finds the entity by ID.
	 *
	 * @param id The ID of the entity.
	 *
	 * @return The entity if found.
	 *
	 * @throws NoSuchEntity When the provided ID is not in this storage.
	 */
	T find(UUID id) throws NoSuchEntity;

	/**
	 * The type of entity this storage stores.
	 *
	 * @return A string representing the type.
	 */
	String type();

}
