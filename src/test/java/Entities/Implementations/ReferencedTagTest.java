package Entities.Implementations;

import Entities.Reference.Reference;
import Entities.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReferencedTagTest {

	@Test
	public void testName() {
		Tag tag = new TagImpl("test");
		Reference<Tag> reference = new Reference<>(tag);
		ReferencedTag tagReference = new ReferencedTag(reference);

		Assertions.assertEquals(tag.name(), tagReference.name());
	}

}
