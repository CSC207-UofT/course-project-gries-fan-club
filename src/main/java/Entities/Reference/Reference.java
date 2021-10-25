package Entities.Reference;

import Entities.Entity;
import Storages.Exceptions.NoEntityFound;
import Storages.Storage;

import java.util.UUID;

/**
 * Allows for lazy loading of entities.
 *
 * Each reference points to exactly one entity.
 * When accessed, the reference is either loaded and returned or simply
 * returned if it has already been loaded.
 *
 * @param <T> The type of entity this is referencing.
 */
public class Reference<T extends Entity> {
	private final UUID id;
	private T entity;
	private Storage<T> storage;

	private boolean loaded = false;

	/**
	 * Creates a reference that will lazy-load an entity.
	 *
	 * @param id The ID of the entity.
	 * @param storage The storage to search.
	 */
	public Reference(UUID id, Storage<T> storage) {
		this.id = id;
		this.storage = storage;
	}

	public Reference(T entity) {
		this.id = entity.id();
		this.entity = entity;
		this.loaded = true;
	}

	/**
	 * Loads and / or returns the referenced entity.
	 *
	 * @return The referenced entity.
	 */
	public T get() throws NoEntityFound {
		if(!this.loaded) {
			this.entity = this.storage.find(this.id);

			this.loaded = true;
		}

		return this.entity;
	}
}
