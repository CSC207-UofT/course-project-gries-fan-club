package Entities.Builders;

import Entities.Exceptions.InvalidRowShape;
import Entities.Implementations.TagImpl;
import Entities.Ingredient;
import Entities.Tag;
import Loaders.Implementations.EmptyRow;
import Loaders.Implementations.RowImpl;
import Loaders.Row;
import Storages.Implementations.AbstractStorage;
import Storages.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IngredientBuilderTest {

	IngredientBuilder builder;
	Storage<Tag> tagStorage;

	/**
	 * A mock storage for testing.
	 */
	static class MockStorage extends AbstractStorage<Tag> {
		@Override
		public String type() {
			return "test";
		}
	}

	@BeforeEach
	public void setUp() {
		this.tagStorage = new MockStorage();
		this.builder = new IngredientBuilder(this.tagStorage);
	}

	/**
	 * Ensures the "ingredient" type was specified.
	 */
	@Test
	public void testType() {
		Assertions.assertEquals("ingredient", this.builder.type());
	}

	/**
	 * Ensures that ingredients are build correctly.
	 */
	@Test
	public void testLoadEntity() throws InvalidRowShape {
		// First we must create some tags and values for rows.
		Tag tag1 = new TagImpl("veggie");
		Tag tag2 = new TagImpl("orange");
		this.tagStorage.add(tag1);
		this.tagStorage.add(tag2);

		List<String> tagIDs = new ArrayList<>();
		tagIDs.add(tag1.id().toString());
		tagIDs.add(tag2.id().toString());

		Map<String, Object> values1 = new HashMap<>();
		values1.put("name", "carrot");
		values1.put("tags", tagIDs);

		Row row = new RowImpl("ingredient", values1);

		// Now use an Ingredient builder to create an ingredient.
		Ingredient ingredient = this.builder.loadEntity(row);

		Assertions.assertEquals("carrot", ingredient.name());

		// Ensure that tags were referenced properly from their IDs.
		Assertions.assertTrue(ingredient.has(tag1));
		Assertions.assertTrue(ingredient.has(tag2));
		Assertions.assertFalse(ingredient.has(new TagImpl("dairy")));

		// Ensure that errors are thrown for invalid rows.
		Assertions.assertThrows(
						InvalidRowShape.class,
						() -> this.builder.loadEntity(new EmptyRow())
		);
	}

}
