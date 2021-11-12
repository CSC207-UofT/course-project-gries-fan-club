package Entities.Serializers;

import Entities.Entity;
import Loaders.Row;

import java.util.Collection;

/**
 * Converts Entities into rows for serialization.
 */
public interface EntitySerializer<T extends Entity> {

	/**
	 * Converts a single entity into a row.
	 *
	 * @param entity The entity to be made into a row.
	 *
	 * @return The row representing the entity.
	 */
	Row serializeEntity(T entity);

	/**
	 * Converts all entities into a row.
	 *
	 * @param entities The list of entities.
	 *
	 * @return A collection of rows representing the entities.
	 */
	Collection<Row> serializeAll(Collection<T> entities);

}
