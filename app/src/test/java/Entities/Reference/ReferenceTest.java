package Entities.Reference;

import Entities.Implementations.TagImpl;
import Entities.Tag;
import Storages.Exceptions.NoSuchEntity;
import Storages.Implementations.AbstractStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class ReferenceTest {

	/**
	 * A mock storage for testing references.
	 */
	static class MockStorage extends AbstractStorage<Tag> {
		@Override
		public String type() {
			return "test";
		}
	}

	/**
	 * Ensure the ID is returned.
	 */
	@Test
	public void testID() {
		Tag tag = new TagImpl("test");
		Reference<Tag> reference = new Reference<>(tag);

		Assertions.assertEquals(tag.id(), reference.id());
	}

	/**
	 * Ensures the get function returns the referenced entity.
	 */
	@Test
	public void testGet() throws NoSuchEntity {
		// We will use a tag as our test entity.
		Tag tag1 = new TagImpl("test");

		// This reference did not need to lazy-load. The tag should be returned.
		Reference<Tag> reference1 = new Reference<>(tag1);
		Assertions.assertEquals(tag1, reference1.get());

		MockStorage storage = new MockStorage();
		storage.add(tag1);

		// This reference does need to lazy-load. The tag should be returned.
		Reference<Tag> reference2 = new Reference<>(tag1.id(), storage);
		Assertions.assertEquals(tag1, reference2.get());

		// This reference does not exist. An error should be thrown.
		UUID badID = UUID.randomUUID();
		Reference<Tag> reference3 = new Reference<>(badID, storage);
		Assertions.assertThrows(NoSuchEntity.class, reference3::get);
	}

}
