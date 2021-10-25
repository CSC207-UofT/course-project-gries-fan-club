package Loaders;

import Loaders.Implementations.RowImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RowImplTest {

	RowImpl row;
	RowImpl emptyRow;

	@BeforeEach
	public void setup() {
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("a", 1);
		attributes.put("b", 2);

		this.row = new RowImpl("myType", attributes);
		this.emptyRow = new RowImpl("myType");
	}

	@Test
	public void testSet() {
		this.emptyRow.set("a", 1);
		Assertions.assertFalse(this.emptyRow.empty());
		Assertions.assertEquals(1, this.emptyRow.get("a", Integer.class));
	}

	@Test
	public void testType() {
		Assertions.assertEquals("myType", this.row.type());
	}

	@Test
	public void testEmpty() {
		Assertions.assertFalse(this.row.empty());
		Assertions.assertTrue(this.emptyRow.empty());
	}

	@Test
	public void testGet() {
		Assertions.assertEquals(1, this.row.get("a", Integer.class));
		Assertions.assertEquals(2, this.row.get("b", Integer.class));
	}

}
