package Entities.Implementations;

import Entities.Reference.Reference;
import Entities.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class ReferencedEntityTest {

	static class MockReferencedEntity extends ReferencedEntity<Tag> {
		public MockReferencedEntity(Reference<Tag> reference) {
			super(reference);
		}

		public MockReferencedEntity(UUID id) {
			super(new Reference<>(new TagImpl(id, "test")));
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

	@Test
	public void testCompareTo() {
		UUID firstID = new UUID(0, 1);
		UUID secondID = new UUID(-1, 0);
		UUID thirdID = new UUID(3, 4);

		ReferencedEntity<Tag> obj = new MockReferencedEntity(firstID);
		ReferencedEntity<Tag> obj1 = new MockReferencedEntity(firstID);
		ReferencedEntity<Tag> obj2 = new MockReferencedEntity(secondID);
		ReferencedEntity<Tag> obj3 = new MockReferencedEntity(thirdID);

		Assertions.assertEquals(0, obj.compareTo(obj1));
		Assertions.assertEquals(1, obj.compareTo(obj2));
		Assertions.assertEquals(-1, obj.compareTo(obj3));
	}
}
