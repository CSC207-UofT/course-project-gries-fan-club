package Entities.Builders;

import Entities.Implementations.TagImpl;
import Entities.Tag;
import Loaders.Implementations.EmptyRow;
import Loaders.Implementations.RowImpl;
import Loaders.Loader;
import Loaders.Row;
import Storages.Implementations.AbstractStorage;
import Storages.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AbstractBuilderTest {

	private final MockBuilder builder = new MockBuilder();
	private final MockLoader loader = new MockLoader();

	/**
	 * A mock builder to test the abstract builder.
	 */
	static class MockBuilder extends AbstractBuilder<Tag> {
		@Override
		protected Tag loadEntity(Row row) {
			return new TagImpl("207");
		}

		@Override
		public String type() {
			return "test";
		}
	}

	/**
	 * A mock loader that returns three rows.
	 */
	static class MockLoader implements Loader {
		private int count = 0;

		static Map<String, Object> attributes;

		static {
			attributes = new HashMap<>();
			attributes.put("attr", 1);
		}

		@Override
		public Row readRow() {
			// Return one of three rows.
			return switch (count++) {
				case 0 -> new RowImpl("test", attributes);
				case 1 -> new RowImpl("bad", attributes);
				default -> new EmptyRow();
			};
		}

		@Override
		public void resetReader() {
			this.count = 0;
		}
	}

	/**
	 * A mock storage for testing.
	 */
	static class MockStorage extends AbstractStorage<Tag> {
		@Override
		public String type() {
			return "test";
		}
	}

	/**
	 * Ensures the loadFrom function only loads valid rows and utilises the
	 * provided creation function.
	 */
	@Test
	public void testLoadFrom() {
		Collection<Tag> loaded = this.builder.loadFrom(this.loader);

		// Only one row was of the right type.
		Assertions.assertEquals(1, loaded.size());

		// The returned Tag is from the CreateEntity Function.
		Assertions.assertEquals("207", loaded.iterator().next().name());

		// Lastly, ensure that the reader is reset when loading.
		this.loader.readRow();
		loaded = this.builder.loadFrom(this.loader);
		Assertions.assertEquals(1, loaded.size());
	}

	/**
	 * Ensures all valid objects are added to a storage.
	 */
	@Test
	public void testAddTo() {
		Storage<Tag> storage = new MockStorage();

		this.builder.addTo(storage, this.loader);

		// Ensure the entity was added to the storage.
		Assertions.assertEquals(1, storage.size());
		Assertions.assertEquals("207", storage.iterator().next().name());
	}

}
