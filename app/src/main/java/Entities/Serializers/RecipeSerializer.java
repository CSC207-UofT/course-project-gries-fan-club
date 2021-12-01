package Entities.Serializers;

import Entities.Recipe;
import Entities.RecipeItem;
import Loaders.Implementations.RowImpl;
import Loaders.Row;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class RecipeSerializer extends AbstractSerializer<Recipe> {

	@Override
	public Row serializeEntity(Recipe entity) {
		return new RowImpl("recipe", Map.of(
						"id", entity.id().toString(),
						"name", entity.name(),
						"description", entity.description(),
						"instructions", entity.instructions(),
						"items", entity.items().stream()
										.map(RecipeItem::id)
										.map(UUID::toString)
										.collect(Collectors.toList())
		));
	}
}
