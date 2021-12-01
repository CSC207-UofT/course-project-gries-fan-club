package Loaders.Implementations;

import Loaders.Loader;
import Loaders.Row;
import Loaders.RowWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.*;

/**
 * Loads data from JSON format.
 *
 * This loader requires source data to be an array of JSON objects.
 * Each of these objects must have a key 'type' associated with a string value.
 */
public class JSONFileIO implements Loader, RowWriter {

	private final JSONArray source;
	private int index = 0;

	public JSONFileIO() throws JSONException {
		this("[]");
	}

	/**
	 * Constructs a loader from predefined JSON objects.
	 *
	 * @param source The JSON source, must be an array.
	 */
	public JSONFileIO(JSONArray source) {
		this.source = source;
	}

	/**
	 * Constructs a loader from a string.
	 *
	 * @param source A string representing a JSON array.
	 */
	public JSONFileIO(String source) throws JSONException {
		this.source = new JSONArray(source);
	}

	/**
	 * Constructs a loader from a JSON file.
	 *
	 * @param sourceFilePath The path of the file to read.
	 *
	 */
	public JSONFileIO(Path sourceFilePath) throws IOException, JSONException {
		// @TODO FIX
		this("");
	}

	@Override
	public Row readRow() {
		if (!this.validIndex()) {
			return new EmptyRow();
		}

		JSONObject currentObject;
		String rowType;

		try {
			currentObject = this.source.getJSONObject(this.index++);
			rowType = currentObject.getString("type");
		} catch (JSONException exception) {
			return new EmptyRow();
		}
		RowImpl row = new RowImpl(rowType);

		// Gather each key of the object as a value for this row.
		for (Iterator<String> it = currentObject.keys(); it.hasNext(); ) {
			String key = it.next();
			if (key.equals("type")) {
				// Do not add the type key as an attribute.
				continue;
			}

			try {
				Object value = currentObject.get(key);

				// We do not want to return JSONArrays outside this class.
				if(isJSONArray(value)) {
					value = convertToNativeArray((JSONArray) value);
				} else if(isJSONObject(value)) {
					value = convertToNativeObject((JSONObject) value);
				}

				row.set(key, value);

			} catch (JSONException ignored) {
				// For now, we will ignore errant rows.
			}
		}

		return row;
	}

	/**
	 * Point back to the beginning of our array.
	 */
	@Override
	public void resetReader() {
		this.index = 0;
	}

	@Override
	public void save(Collection<Row> rows, Writer toWrite) throws Exception {
		JSONArray sourceToSave = new JSONArray();

		// Transform the rows into JSON objects.
		for (Row row : rows) {
			JSONObject object = new JSONObject();
			object.put("type", row.type());

			for (String key : row.keySet()) {
				object.put(key, row.get(key, Object.class));
			}

			sourceToSave.put(object);
		}

		toWrite.write(sourceToSave.toString(2));
	}

	/**
	 * Determines if the current index is valid for our source.
	 *
	 * @return Whether the index is valid
	 */
	private boolean validIndex() {
		return 0 <= this.index && this.index < this.source.length();
	}

	/**
	 * Determines if an object is a JSON array.
	 *
	 * @param object The object to check.
	 *
	 * @return Whether the object is an array.
	 */
	private static boolean isJSONArray(Object object) {
		return object instanceof JSONArray;
	}

	/**
	 * Determines if an object is a JSON object.
	 *
	 * @param object The object to check.
	 *
	 * @return Whether the object is an object.
	 */
	private static boolean isJSONObject(Object object) {
		return object instanceof JSONObject;
	}

	/**
	 * Converts a JSON array into a basic arrays containing only primitives.
	 *
	 * We need to keep the JSON objects, which are implementations, away from an outside user.
	 * If any element in our array is another JSON array it will be recursively passed to this function.
	 * Anything that is simply primitives will be kept as is.
	 *
	 * This does not change the shape of the array, just the types.
	 *
	 * @param array A JSON array to be de-JSONed
	 *
	 * @return A list of non-JSON objects that are only arrays and primitives.
	 */
	private static List<Object> convertToNativeArray(JSONArray array) throws JSONException {
		List<Object> objects = new ArrayList<>();

		for(int i = 0; i < array.length(); i++) {
			Object object = array.get(i);

			// Any array objects must be further simplified.
			if (isJSONArray(object)) {
				objects.add(convertToNativeArray((JSONArray) object));
				continue;
			}

			// If the object is a JSON object, turn it into a map.
			if (isJSONObject(object)) {
				objects.add(convertToNativeObject((JSONObject) object));
				continue;
			}

			// Otherwise, we simply add the object.
			objects.add(object);
		}

		return objects;
	}

	/**
	 * Converts a JSON object into a Map of Strings to Objects.
	 *
	 * @see JSONFileIO#convertToNativeArray(JSONArray), for details on de-JSONing data objects.
	 *
	 * This will keep the same key structure as the JSONObject coming in but will
	 * place it into a Map instead.
	 *
	 * @param object The JSON object to de-JSON
	 *
	 * @return A Map with no JSON objects within it.
	 */
	private static Map<String, Object> convertToNativeObject(JSONObject object) throws JSONException {
		Map<String, Object> mapObject = new HashMap<>();

		// Retrieve and de-JSON any nested objects within this.
		for (Iterator<String> it = object.keys(); it.hasNext(); ) {
			String key = it.next();

			Object value = object.get(key);

			if(isJSONArray(value)) {
				mapObject.put(key, convertToNativeArray((JSONArray) value));
				continue;
			}

			if(isJSONObject(value)) {
				mapObject.put(key, convertToNativeObject((JSONObject) value));
				continue;
			}

			mapObject.put(key, value);

		}

		return mapObject;
	}

}
