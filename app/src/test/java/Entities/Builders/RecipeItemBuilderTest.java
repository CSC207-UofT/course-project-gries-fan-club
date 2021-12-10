package Entities.Builders;

import Entities.Exceptions.InvalidRowShape;
import Entities.Ingredient;
import Entities.RecipeItem;
import Loaders.Implementations.EmptyRow;
import Loaders.Implementations.RowImpl;
import Loaders.Row;
import Storages.Implementations.AbstractStorage;
import Storages.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RecipeItemBuilderTest {

	RecipeItemBuilder builder;
	Storage<Ingredient> storage;

	/**
	 * A mock storage for testing.
	 */
	static class MockStorage extends AbstractStorage<Ingredient> {
		@Override
		public String type() {
			return "test";
		}
	}

	@BeforeEach
	public void setUp() {
		this.storage = new MockStorage();
		this.builder = new RecipeItemBuilder(this.storage);
	}

	@Test
	public void testLoadEntity() throws InvalidRowShape {
		UUID itemID = UUID.randomUUID();
		UUID ingredientID = UUID.randomUUID();
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("id", itemID.toString());
		attributes.put("ingredient", ingredientID.toString());
		attributes.put("quantity", 0.5);
		attributes.put("optional", true);
		attributes.put("displayType", "q");
		Row row = new RowImpl("recipeItem", attributes);

		RecipeItem item = this.builder.loadEntity(row);
		Assertions.assertEquals(itemID, item.id());
		Assertions.assertEquals(ingredientID, item.ingredient().id());
		Assertions.assertEquals(0.5f, item.quantity());
		Assertions.assertTrue(item.optional());

		Assertions.assertThrows(
						InvalidRowShape.class,
						() -> this.builder.loadEntity(new EmptyRow())
		);

		// Allow any Number to be cast to doubles.
		attributes.put("quantity", 3);
		item = this.builder.loadEntity(row);
		Assertions.assertEquals(3.0, item.quantity());
	}

	@Test
	public void testType() {
		Assertions.assertEquals("recipeItem", this.builder.type());
	}

}
