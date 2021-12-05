package Entities.Serializers;

import Entities.Entity;
import Loaders.Row;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A base for entity serializers.
 *
 * @param <T> The type of entity to serialize.
 */
public abstract class AbstractSerializer<T extends Entity> implements EntitySerializer<T> {

	@Override
	public Collection<Row> serializeAll(Collection<T> entities) {
		Collection<Row> rows = new ArrayList<>();

		for (T entity : entities) {
			rows.add(this.serializeEntity(entity));
		}

		return rows;
	}

}
