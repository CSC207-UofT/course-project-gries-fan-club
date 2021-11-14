package Entities.Builders;

import Entities.Exceptions.InvalidRowShape;
import Entities.Recipe;
import Entities.RecipeItem;
import Loaders.Implementations.RowImpl;
import Loaders.Row;
import Storages.Implementations.AbstractStorage;
import Storages.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RecipeBuilderTest {

	RecipeBuilder builder;
	Storage<RecipeItem> itemStorage;

	/**
	 * A mock storage for testing.
	 */
	static class MockStorage extends AbstractStorage<RecipeItem> {
		@Override
		public String type() {
			return "test";
		}
	}

	@BeforeEach
	public void setUp() {
		this.itemStorage = new RecipeBuilderTest.MockStorage();
		this.builder = new RecipeBuilder(this.itemStorage);
	}

	/**
	 * Ensures the "recipe" type was specified.
	 */
	@Test
	public void testType() {
		Assertions.assertEquals("recipe", this.builder.type());
	}

	@Test
	public void testLoadEntity() throws InvalidRowShape {

		// Create the row object representing our recipe.
		UUID recipeID = UUID.randomUUID();
		Map<String, Object> values = new HashMap<>();
		values.put("id", recipeID.toString());
		values.put("name", "Bread");
		values.put("description", "A loaf of bread");
		values.put("instructions", Arrays.asList(
						"Mix",
						"Knead",
						"Bake"
		));

		UUID itemID1 = new UUID(0, 1);
		UUID itemID2 = new UUID(1, 2);
		values.put("items", List.of(
						itemID1.toString(),
						itemID2.toString()
		));

		Row row = new RowImpl("ingredient", values);

		Recipe recipe = this.builder.loadEntity(row);

		// Ensure values were properly assigned.
		Assertions.assertEquals(recipeID, recipe.id());
		Assertions.assertEquals("Bread", recipe.name());
		Assertions.assertEquals("A loaf of bread", recipe.description());

		List<String> instructions = recipe.instructions();
		Assertions.assertEquals("Mix", instructions.get(0));
		Assertions.assertEquals("Knead", instructions.get(1));
		Assertions.assertEquals("Bake", instructions.get(2));

		List<RecipeItem> recipeItems = recipe.items();
		Collections.sort(recipeItems);
		Assertions.assertEquals(itemID1, recipeItems.get(0).id());
		Assertions.assertEquals(itemID2, recipeItems.get(1).id());
	}

}
