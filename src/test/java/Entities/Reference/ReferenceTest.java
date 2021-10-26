package Entities.Reference;

import Entities.Implementations.TagImpl;
import Entities.Tag;
import Storages.Exceptions.NoSuchEntity;
import Storages.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class ReferenceTest {

	/**
	 * A mock storage for testing references.
	 */
	record SingleStorage(Tag tag) implements Storage<Tag> {
		@Override
		public Tag find(UUID id) throws NoSuchEntity {
			// If our tag is requested return it.
			if (id.equals(this.tag.id())) {
				return this.tag;
			}

			throw new NoSuchEntity(id);
		}
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

		SingleStorage storage = new SingleStorage(tag1);

		// This reference does need to lazy-load. The tag should be returned.
		Reference<Tag> reference2 = new Reference<>(tag1.id(), storage);
		Assertions.assertEquals(tag1, reference2.get());

		// This reference does not exist. An error should be thrown.
		UUID badID = UUID.randomUUID();
		Reference<Tag> reference3 = new Reference<>(badID, storage);
		Assertions.assertThrows(NoSuchEntity.class, reference3::get);
	}

}
