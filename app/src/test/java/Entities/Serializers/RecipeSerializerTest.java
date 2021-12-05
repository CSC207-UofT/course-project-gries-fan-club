package Entities.Serializers;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.RecipeImpl;
import Entities.Implementations.RecipeItemImpl;
import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.RecipeItemDisplay;
import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;
import RecipeItemDisplayers.Quantifiable;
import RecipeItemDisplayers.Volumetric;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class RecipeSerializerTest {

	@Test
	public void testSerializeEntity() throws NoSuchAttribute {
		Ingredient ingredient = new IngredientImpl("", Collections.emptyList());
		RecipeItemDisplay quantifiable = new Quantifiable();
		RecipeItemDisplay volumetric = new Volumetric();
		RecipeItem item1 = new RecipeItemImpl(ingredient, 0, false, quantifiable);
		RecipeItem item2 = new RecipeItemImpl(ingredient, 0, false, volumetric);

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
