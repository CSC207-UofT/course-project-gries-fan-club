package Entities.Serializers;

import Entities.Implementations.TagImpl;
import Entities.Tag;
import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TagSerializerTest {

	/**
	 * Ensures the ID and name were added to the row.
	 */
	@Test
	public void testSerializeEntity() throws NoSuchAttribute {
		Tag tag = new TagImpl("dairy");

		Row row = new TagSerializer().serializeEntity(tag);
		Assertions.assertEquals("tag", row.type());
		Assertions.assertEquals(tag.id().toString(), row.get("id", String.class));
		Assertions.assertEquals(tag.name(), row.get("name", String.class));
	}

}
