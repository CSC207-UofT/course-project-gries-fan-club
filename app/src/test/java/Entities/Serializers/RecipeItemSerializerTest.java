package Entities.Serializers;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.QuantityRecipeItem;
import Entities.Ingredient;
import Entities.RecipeItem;
import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class RecipeItemSerializerTest {

	@Test
	public void testSerializeEntity() throws NoSuchAttribute {
		Ingredient ingredient = new IngredientImpl("test", Collections.emptyList());
		RecipeItem item = new QuantityRecipeItem(ingredient, 1.4f, false);

		Row row = new RecipeItemSerializer().serializeEntity(item);
		Assertions.assertEquals("recipeItem", row.type());

		// Ensure IDs were assigned properly.
		Assertions.assertEquals(item.id().toString(), row.get("id", String.class));
		Assertions.assertEquals(ingredient.id().toString(), row.get("ingredient", String.class));

		// Ensure all properties of our items were assigned properly.
		Assertions.assertEquals(1.4f, row.get("quantity", Float.class));
		Assertions.assertFalse(row.get("optional", Boolean.class));
		Assertions.assertEquals(item.serializeTypeCode(), row.get("type", String.class));
	}

}
