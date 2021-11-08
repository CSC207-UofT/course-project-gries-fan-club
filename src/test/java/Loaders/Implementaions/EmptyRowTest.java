package Loaders.Implementaions;

import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Implementations.EmptyRow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmptyRowTest {

	EmptyRow row;

	@BeforeEach
	public void setup() {
		this.row = new EmptyRow();
	}

	@Test
	public void testType() {
		Assertions.assertEquals("", this.row.type());
	}

	@Test
	public void testEmpty() {
		Assertions.assertTrue(this.row.empty());
	}

	@Test
	public void testGet() {
		Assertions.assertThrows(
						NoSuchAttribute.class,
						() -> this.row.get("test", String.class)
		);
	}

	@Test
	public void testGetAsList() {
		Assertions.assertThrows(
						NoSuchAttribute.class,
						() -> this.row.getAsList("test", String.class)
		);
	}

	@Test
	public void testGetAsMap() {
		Assertions.assertThrows(
						NoSuchAttribute.class,
						() -> this.row.getAsMap("test", String.class)
		);
	}

}
