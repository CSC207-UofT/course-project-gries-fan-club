package Entities.Serializers;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.RecipeItemImpl;
import Entities.Ingredient;
import Entities.ItemDisplays.Quantifiable;
import Entities.ItemDisplays.RecipeItemDisplay;
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
		RecipeItemDisplay quantifiable = new Quantifiable();
		RecipeItem item = new RecipeItemImpl(ingredient, 1.4f, false, quantifiable);

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
