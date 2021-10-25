package Storages;

import Entities.Entity;
import Storages.Exceptions.NoEntityFound;

import java.util.UUID;

public interface Storage<T extends Entity> {

	/**
	 * Finds the entity by ID.
	 *
	 * @param id The ID of the entity.
	 *
	 * @return The entity if found.
	 *
	 * @throws NoEntityFound When the provided ID is not in this storage.
	 */
	T find(UUID id) throws NoEntityFound;

}
