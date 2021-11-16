package Entities.Implementations;

import Entities.Ingredient;
import Entities.Reference.Reference;
import Entities.Tag;
import Storages.Implementations.AbstractStorage;
import Storages.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ReferencedIngredientTest {

	ReferencedIngredient readyIngredient;
	ReferencedIngredient unloadedIngredient;

	final Storage<Ingredient> mockStorage = new ReferencedIngredientTest.MockStorage();

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
		Ingredient ingredient = new IngredientImpl(
						"apple",
						Collections.singletonList(new TagImpl("fruit"))
		);

		Reference<Ingredient> reference1 = new Reference<>(ingredient);
		Reference<Ingredient> reference2 = new Reference<>(UUID.randomUUID(), this.mockStorage);

		this.readyIngredient = new ReferencedIngredient(reference1);
		this.unloadedIngredient = new ReferencedIngredient(reference2);
	}

	@Test
	public void testTags() {
		List<Tag> tags = this.readyIngredient.tags();
		Assertions.assertEquals("fruit", tags.get(0).name());

		Assertions.assertNull(this.unloadedIngredient.tags());
	}

	@Test
	public void testHas() {
		Assertions.assertTrue(this.readyIngredient.has(new TagImpl("fruit")));
		Assertions.assertFalse(this.unloadedIngredient.has(new TagImpl("fruit")));
	}

	@Test
	public void testName() {
		Assertions.assertEquals("apple", this.readyIngredient.name());
		Assertions.assertEquals(
						this.unloadedIngredient.id().toString(),
						this.unloadedIngredient.name()
		);
	}

}
