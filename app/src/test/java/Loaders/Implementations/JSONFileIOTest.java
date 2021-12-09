package Loaders.Implementations;

import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.util.*;

public class JSONFileIOTest {

	JSONFileIO loader;
	JSONFileIO nestedLoader;

	/**
	 * Below are the JSON sources used in the class loaders.
	 */
	static final String SOURCE = "[{" +
					"\"type\": \"test\"," +
					"\"value\": 3" +
					"},{" +
					"\"type\": \"test\"," +
					"\"value\": 4" +
					"}]";

	static final String NESTED_SOURCE = "[{" +
					"\"type\": \"test\"," +
					"\"values\": [" +
					"4," +
					"5" +
					"]" +
					"},{" +
					"\"type\": \"test\"," +
					"\"obj\": {" +
					"\"inner_value\": 6" +
					"}}]";


	@BeforeEach
	public void setup() throws JSONException {
		this.loader = new JSONFileIO(SOURCE);
		this.nestedLoader = new JSONFileIO(NESTED_SOURCE);
	}

	@Test
	public void testReadRow() throws NoSuchAttribute {

		// Ensure the loader can construct rows from flat JSON objects.
		Row row1 = this.loader.readRow();
		Assertions.assertEquals("test", row1.type());
		Assertions.assertEquals(3, row1.get("value", Integer.class));

		Row row2 = this.loader.readRow();
		Assertions.assertEquals("test", row2.type());
		Assertions.assertEquals(4, row2.get("value", Integer.class));

		Row row3 = this.loader.readRow();
		Assertions.assertTrue(row3.empty());

		// Ensure that nested arrays and JSON objects are correctly loaded.
		Row row4 = this.nestedLoader.readRow();
		List<Integer> extractedList = row4.getAsList("values", Integer.class);
		Assertions.assertEquals(2, extractedList.size());
		Assertions.assertEquals(4, extractedList.get(0));
		Assertions.assertEquals(5, extractedList.get(1));

		Row row5 = this.nestedLoader.readRow();
		Map<String, Integer> extractedMap = row5.getAsMap("obj", Integer.class);
		Assertions.assertEquals(6, extractedMap.get("inner_value"));
	}

	@Test
	public void testResetRow() throws NoSuchAttribute {
		Row row1 = this.loader.readRow();

		this.loader.resetReader();

		Row row3 = this.loader.readRow();

		Assertions.assertEquals(
						row1.get("value", Integer.class),
						row3.get("value", Integer.class)
		);
	}

	@Test
	public void testSave() throws Exception {

		StringWriter writer = new StringWriter();
		List<Row> rows = new ArrayList<>();
		rows.add(this.loader.readRow());
		rows.add(this.loader.readRow());

		this.loader.save(rows, writer);
		String jsonNoSpace = writer.toString().replaceAll("\\s+","");
		String sourceNoSpace = SOURCE.replaceAll("\\s+", "");

		Assertions.assertEquals(sourceNoSpace, jsonNoSpace);

		// Ensure non-integer values are saved.
		Map<String, Object> values = new HashMap<>();
		values.put("val", 4.0);
		Row row = new RowImpl("test", values);

		writer = new StringWriter();
		this.loader.save(Collections.singletonList(row), writer);
		String rawJSON = writer.toString();

		JSONObject obj = new JSONObject();
		obj.put("test", 1.23);
		Assertions.assertEquals("{\"test\":1.23}", obj.toString());
	}

}
