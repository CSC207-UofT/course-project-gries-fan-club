package Loaders;

import Loaders.Implementations.JSONLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JSONLoaderTest {

	JSONLoader loader;

	static final JSONObject ROW_1 = new JSONObject()
					.put("type", "test")
					.put("value", 3);

	static final JSONObject ROW_2 = new JSONObject()
					.put("type", "test")
					.put("value", 4);

	static final JSONArray SOURCE = new JSONArray()
					.put(ROW_1)
					.put(ROW_2);

	static final JSONArray VALUES = new JSONArray()
					.put(4)
					.put(5);

	static final JSONObject NESTED_OBJECT = new JSONObject()
					.put("type", "test")
					.put("values", VALUES);

	static final JSONArray NESTED_SOURCE = new JSONArray()
					.put(NESTED_OBJECT);

	@BeforeEach
	public void setup() {
		this.loader = new JSONLoader(SOURCE);
	}

	@Test
	public void testReadRow() {
		Row row1 = this.loader.readRow();
		Assertions.assertEquals("test", row1.type());
		Assertions.assertEquals(3, row1.get("value", Integer.class));

		Row row2 = this.loader.readRow();
		Assertions.assertEquals("test", row2.type());
		Assertions.assertEquals(4, row2.get("value", Integer.class));

		Row row3 = this.loader.readRow();
		Assertions.assertTrue(row3.empty());

		JSONLoader nestedLoader = new JSONLoader(NESTED_SOURCE);
		Row row4 = nestedLoader.readRow();
		List extractedList = row4.get("values", List.class);
		Assertions.assertEquals(2, extractedList.size());
		Assertions.assertEquals(4, extractedList.get(0));
		Assertions.assertEquals(5, extractedList.get(1));
	}

	@Test
	public void testResetRow() {
		Row row1 = this.loader.readRow();

		this.loader.resetReader();

		Row row3 = this.loader.readRow();

		Assertions.assertEquals(
						row1.get("value", Integer.class),
						row3.get("value", Integer.class)
		);
	}

}
