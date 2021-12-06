package Entities.Serializers;

import Entities.RecipeItem;
import Loaders.Implementations.RowImpl;
import Loaders.Row;

import java.util.Map;

public class RecipeItemSerializer extends AbstractSerializer<RecipeItem> {

	@Override
	public Row serializeEntity(RecipeItem entity) {
		return new RowImpl("recipeItem", Map.of(
						"id", entity.id().toString(),
						"ingredient", entity.ingredient().id().toString(),
						"quantity", entity.quantity(),
						"optional", entity.optional(),
						"displayType", entity.serializeTypeCode()
		));
	}

}
