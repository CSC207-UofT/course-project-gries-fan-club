package Storages.Implementations;

import Entities.Entity;
import Storages.Exceptions.NoSuchEntity;
import Storages.Storage;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/**
 * Implements a basic storage for entities.
 *
 * @param <T> The type of entity.
 */
public abstract class AbstractStorage<T extends Entity> extends AbstractCollection<T> implements Storage<T> {

	/**
	 * This maps to entities via their ID's.
	 */
	protected final HashMap<String, T> entities = new HashMap<>();

	/**
	 * Finds an entity by ID.
	 *
	 * @param id The ID of the entity.
	 *
	 * @return The found entity.
	 *
	 * @throws NoSuchEntity Throws this exception when no entity is found.
	 */
	@Override
	public T find(UUID id) throws NoSuchEntity {
		T entity = this.entities.get(id.toString());

		if (entity == null) {
			throw new NoSuchEntity(id);
		}

		return entity;
	}

	@Override
	public Iterator<T> iterator() {
		return this.entities.values().iterator();
	}

	@Override
	public int size() {
		return this.entities.size();
	}

	/**
	 * Stores the given entity via its ID.
	 *
	 * @param entity The entity to store.
	 *
	 * @return Whether there used to be an entity of the same ID.
	 */
	@Override
	public boolean add(T entity) {
		return this.entities.put(entity.id().toString(), entity) != null;
	}

	/**
	 * Checks to see if the given entity is in the storage.
	 *
	 * @param id The id of the entity to be checked.
	 *
	 * @return Whether the entity is in the storage.
	 */
	public boolean contains(UUID id) { return this.entities.get(id.toString()) != null; }

	/**
	 * Removes given entity from the storage.
	 *
	 * @param id The id of the entity to be checked.
	 *
	 * @return Whether the entity was removed.
	 */
	public boolean remove(UUID id) { return this.entities.remove(id.toString()) != null; }

}
