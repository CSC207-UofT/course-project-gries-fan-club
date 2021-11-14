package Entities.Serializers;

import Entities.Ingredient;
import Loaders.Implementations.RowImpl;
import Loaders.Row;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Serializes ingredients.
 */
public class IngredientSerializer extends AbstractSerializer<Ingredient> {

	@Override
	public Row serializeEntity(Ingredient entity) {
		Map<String, Object> values = Map.of(
						"id", entity.id().toString(),
						"name", entity.name(),
						"tags", entity.tags().stream()
										.map(tag -> tag.id().toString())
										.collect(Collectors.toList())
		);

		return new RowImpl("ingredient", values);
	}

}
