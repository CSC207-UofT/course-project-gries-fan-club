package Entities.Serializers;

import Entities.Entity;
import Loaders.Implementations.RowImpl;
import Loaders.Row;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class AbstractSerializerTest {

	/**
	 * Provides a dummy serializer to test the abstract class.
	 */
	private static class MockSerializer extends AbstractSerializer<Entity> {
		@Override
		public Row serializeEntity(Entity entity) {
			return new RowImpl("test");
		}
	}

	@Test
	public void testSerializeAll() {

		// Since we don't need to operate on entities, nulls are fine.
		Collection<Entity> entities = new ArrayList<>();
		entities.add(null);
		entities.add(null);

		Collection<Row> rows = new MockSerializer().serializeAll(entities);
		Assertions.assertEquals(2, rows.size());

		Row row = rows.iterator().next();
		Assertions.assertEquals("test", row.type());

	}

}
