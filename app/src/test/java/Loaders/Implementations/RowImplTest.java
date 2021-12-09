package Loaders.Implementations;

import Loaders.Exceptions.NoSuchAttribute;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RowImplTest {

	RowImpl row;
	RowImpl emptyRow;

	@BeforeEach
	public void setup() {
		List<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(8);

		Map<String, Integer> map = new HashMap<>();
		map.put("key", 123);

		Map<String, Object> attributes = new HashMap<>();
		attributes.put("a", 1);
		attributes.put("b", 2);
		attributes.put("c", 3.0);
		attributes.put("l", list);
		attributes.put("m", map);

		this.row = new RowImpl("myType", attributes);
		this.emptyRow = new RowImpl("myType");
	}

	@Test
	public void testSet() throws NoSuchAttribute {
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
	public void testKeySet() {
		Collection<String> keySet = this.row.keySet();
		Assertions.assertTrue(keySet.contains("a"));
		Assertions.assertTrue(keySet.contains("b"));
		Assertions.assertTrue(keySet.contains("l"));
		Assertions.assertTrue(keySet.contains("m"));
		Assertions.assertFalse(keySet.contains("x"));

		Assertions.assertEquals(0, this.emptyRow.keySet().size());
	}

	@Test
	public void testGet() throws NoSuchAttribute {
		Assertions.assertEquals(1, this.row.get("a", Integer.class));
		Assertions.assertEquals(2, this.row.get("b", Integer.class));
	}

	@Test
	public void testGetAsList() throws NoSuchAttribute {
		List<Integer> list = this.row.getAsList("l", Integer.class);
		Assertions.assertEquals(9, list.get(0));
		Assertions.assertEquals(8, list.get(1));

		Assertions.assertThrows(
						NoSuchAttribute.class,
						() -> this.row.getAsList("x", String.class)
		);
	}

	@Test
	public void testGetAsMap() throws NoSuchAttribute {
		Map<String, Integer> map = this.row.getAsMap("m", Integer.class);
		Assertions.assertEquals(123, map.get("key"));

		Assertions.assertThrows(
						NoSuchAttribute.class,
						() -> this.row.getAsMap("x", String.class)
		);
	}

}
