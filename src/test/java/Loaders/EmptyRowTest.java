package Loaders;

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
		Assertions.assertNull(this.row.get("attr", String.class));
	}

}
