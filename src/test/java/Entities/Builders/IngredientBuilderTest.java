package Entities.Builders;

import Entities.Implementations.TagImpl;
import Entities.Ingredient;
import Loaders.Implementations.RowImpl;
import Loaders.Row;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IngredientBuilderTest {

	@Test
	public void testType() {
		Assertions.assertEquals("ingredient", new IngredientBuilder().type());
	}

	@Test
	public void testLoadEntity() {
		Map<String, Object> values = new HashMap<>();
		values.put("name", "carrot");

		List<String> tags = new ArrayList<>();
		tags.add("veggie");
		tags.add("orange");
		values.put("tags", tags);

		Row row = new RowImpl("ingredient", values);
		Ingredient ingredient = new IngredientBuilder().loadEntity(row);

		Assertions.assertEquals("carrot", ingredient.name());
		Assertions.assertTrue(ingredient.has(new TagImpl("veggie")));
		Assertions.assertTrue(ingredient.has(new TagImpl("orange")));
		Assertions.assertFalse(ingredient.has(new TagImpl("dairy")));
	}

}
