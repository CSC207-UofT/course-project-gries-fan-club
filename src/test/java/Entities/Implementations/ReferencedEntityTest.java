package Entities.Implementations;

import Entities.Reference.Reference;
import Entities.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReferencedEntityTest {

	static class MockReferencedEntity extends ReferencedEntity<Tag> {
		public MockReferencedEntity(Reference<Tag> reference) {
			super(reference);
		}
	}

	/**
	 * Ensures the proper ID is returned.
	 */
	@Test
	public void testID() {
		Tag tag = new TagImpl("test");
		Reference<Tag> reference = new Reference<>(tag);

		ReferencedEntity<Tag> referencedEntity = new MockReferencedEntity(reference);
		Assertions.assertEquals(tag.id(), referencedEntity.id());
	}

}
