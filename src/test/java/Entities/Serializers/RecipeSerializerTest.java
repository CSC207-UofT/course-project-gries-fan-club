package Entities.Serializers;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.QuantityRecipeItem;
import Entities.Implementations.RecipeImpl;
import Entities.Implementations.VolumetricRecipeItem;
import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class RecipeSerializerTest {

	@Test
	public void testSerializeEntity() throws NoSuchAttribute {
		Ingredient ingredient = new IngredientImpl("", Collections.emptyList());
		RecipeItem item1 = new QuantityRecipeItem(ingredient, 0, false);
		RecipeItem item2 = new VolumetricRecipeItem(ingredient, 0, false);

		Recipe recipe = new RecipeImpl(
						"Soup",
						"Tasty",
						List.of("Chop", "Cook"),
						List.of(item1, item2)
		);
		Row row = new RecipeSerializer().serializeEntity(recipe);

		Assertions.assertEquals("recipe", row.type());
		Assertions.assertEquals(recipe.id().toString(), row.get("id", String.class));
		Assertions.assertEquals(recipe.name(), row.get("name", String.class));
		Assertions.assertEquals(recipe.description(), row.get("description", String.class));

		List<String> instructions = row.getAsList("instructions", String.class);
		Assertions.assertEquals(2, instructions.size());
		Assertions.assertTrue(instructions.contains("Chop"));
		Assertions.assertTrue(instructions.contains("Cook"));

		List<String> items = row.getAsList("items", String.class);
		Assertions.assertEquals(2, items.size());
		Assertions.assertTrue(items.contains(item1.id().toString()));
		Assertions.assertTrue(items.contains(item2.id().toString()));
	}

}
