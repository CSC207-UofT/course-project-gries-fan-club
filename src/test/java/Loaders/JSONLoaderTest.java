package Loaders;

import LoaderInterfaces.Row;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
