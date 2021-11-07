package Entities.Builders;

import Entities.Exceptions.InvalidRowShape;
import Entities.Tag;
import Loaders.Implementations.EmptyRow;
import Loaders.Implementations.RowImpl;
import Loaders.Row;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TagBuilderTest {

	private TagBuilder builder;

	@BeforeEach
	public void setUp() {
		this.builder = new TagBuilder();
	}

	@Test
	public void testType() {
		Assertions.assertEquals("tag", builder.type());
	}

	@Test
	public void testLoadEntity() throws InvalidRowShape {
		UUID tagID = UUID.randomUUID();
		Map<String, Object> values = new HashMap<>();
		values.put("id", tagID.toString());
		values.put("name", "dairy");

		Row row = new RowImpl("ingredient", values);

		Tag tag = this.builder.loadEntity(row);

		Assertions.assertEquals(tagID, tag.id());
		Assertions.assertEquals("dairy", tag.name());

		// Ensure errors are thrown for invalid rows.
		Assertions.assertThrows(
						InvalidRowShape.class,
						() -> this.builder.loadEntity(new EmptyRow()));
	}

}
