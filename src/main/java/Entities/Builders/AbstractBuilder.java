package Entities.Builders;

import Entities.Entity;
import Loaders.Loader;
import Loaders.Row;
import Storages.Storage;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Defines the common process of validating a loaders data and creating an
 * entity with it.
 * Child builders can control how each specific entity is built.
 *
 * @param <T> The type of entity that this builder creates.
 */
public abstract class AbstractBuilder<T extends Entity> {

	/**
	 * Creates an entity from a given row.
	 *
	 * @param row The row representing the entity
	 *
	 * @return A constructed entity
	 */
	protected abstract T loadEntity(Row row);

	/**
	 * The type of entity this builder creates.
	 *
	 * @return The name as a string
	 */
	public abstract String type();

	/**
	 * Loads all entities from a loader.
	 *
	 * @param loader The loader to load from
	 *
	 * @return All loaded entities
	 */
	public Collection<T> loadFrom(Loader loader) {
		// Ensure all data is loaded.
		loader.resetReader();

		Collection<T> entities = new ArrayList<>();

		Row currentRow;
		do {
			currentRow = loader.readRow();
			if(!this.validType(currentRow)) {
				// Only construct the valid type of entity.
				continue;
			}

			entities.add(this.loadEntity(currentRow));
		} while (!currentRow.empty());

		return entities;
	}

	/**
	 * Adds all entities from a loader into a given storage.
	 *
	 * @param storage The storage to fill
	 * @param loader The loader to pull from
	 */
	public void addTo(Storage<T> storage, Loader loader) {
		if (!storage.type().equals(this.type())) {
			// We can only add entities that this storage allows.
			return;
		}

		storage.addAll(this.loadFrom(loader));
	}

	/**
	 * Determines if a row can be built by this constructor.
	 *
	 * @param row The row to query.
	 *
	 * @return Whether this row can be built.
	 */
	private boolean validType(Row row) {
		return row.type().equals(this.type());
	}

}
