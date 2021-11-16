package Entities.Implementations;

import Entities.Reference.Reference;
import Entities.Tag;
import Storages.Implementations.AbstractStorage;
import Storages.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class ReferencedTagTest {

	final Storage<Tag> mockStorage = new MockStorage();

	/**
	 * A mock storage for testing.
	 */
	static class MockStorage extends AbstractStorage<Tag> {
		@Override
		public String type() {
			return "test";
		}
	}

	@Test
	public void testName() {
		Tag tag = new TagImpl("test");
		Reference<Tag> reference1 = new Reference<>(tag);
		ReferencedTag tagReference1 = new ReferencedTag(reference1);

		Assertions.assertEquals(tag.name(), tagReference1.name());

		// Ensure the ID is returned as the default name.
		UUID id = UUID.randomUUID();
		Reference<Tag> reference2 = new Reference<>(id, this.mockStorage);
		ReferencedTag tagReference2 = new ReferencedTag(reference2);

		Assertions.assertEquals(id.toString(), tagReference2.name());

	}

}
