package Entities.Serializers;

import Entities.Tag;
import Loaders.Implementations.RowImpl;
import Loaders.Row;

import java.util.Map;

/**
 * Serializes a tag.
 */
public class TagSerializer extends AbstractSerializer<Tag> {

	@Override
	public Row serializeEntity(Tag entity) {
		Map<String, Object> values = Map.of(
						"id", entity.id().toString(),
						"name", entity.name()
		);

		return new RowImpl("tag", values);
	}

}
