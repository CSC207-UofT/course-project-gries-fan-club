package Entities.Builders;

import Entities.Entity;
import Entities.Exceptions.InvalidRowShape;
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
public abstract class AbstractBuilder<T extends Entity> implements EntityBuilder<T> {

	@Override
	public Collection<T> loadFrom(Loader loader) {
		// Ensure all data will be loaded.
		loader.resetReader();

		Collection<T> entities = new ArrayList<>();

		Row currentRow = loader.readRow();
		while (!currentRow.empty()) {

			if(!this.validType(currentRow)) {
				// Only construct the valid type of entity.
				currentRow = loader.readRow();
				continue;
			}

			// Try to construct the row into an entity.
			try {

				entities.add(this.loadEntity(currentRow));

			} catch (InvalidRowShape invalidRowShape) {
				invalidRowShape.printStackTrace();
			}

			currentRow = loader.readRow();
		}

		return entities;
	}

	@Override
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
