package Loaders.Implementations;

import Loaders.Loader;
import Loaders.Row;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads data from JSON format.
 *
 * This loader requires source data to be an array of JSON objects.
 * Each of these objects must have a key 'type' associated with a string value.
 */
public class JSONLoader implements Loader {

	private final JSONArray source;
	private int index = 0;

	/**
	 * Constructs a loader from predefined JSON objects.
	 *
	 * @param source The JSON source, must be an array.
	 */
	public JSONLoader(JSONArray source) {
		this.source = source;
	}

	/**
	 * Constructs a loader from a string.
	 *
	 * @param source A string representing a JSON array.
	 */
	public JSONLoader(String source) {
		this.source = new JSONArray(source);
	}

	/**
	 * Constructs a loader from a JSON file.
	 *
	 * @param sourceFilePath The path of the file to read.
	 *
	 * @throws IOException When the given path is invalid / unreadable.
	 */
	public JSONLoader(Path sourceFilePath) throws IOException {
		this(Files.readString(sourceFilePath));
	}

	@Override
	public Row readRow() {
		if (!this.validIndex()) {
			return new EmptyRow();
		}

		JSONObject currentObject = this.source.getJSONObject(this.index++);
		String rowType = currentObject.getString("type");

		RowImpl row = new RowImpl(rowType);

		// Gather each key of the object as a value for this row.
		for(String key : currentObject.keySet()) {
			if (key.equals("type")) {
				// Do not add the type key as an attribute.
				continue;
			}

			Object value = currentObject.get(key);

			if(isArray(value)) {
				// We do not want to return JSONArrays outside this class.
				value = convertToNativeArray((JSONArray) value);
			}

			row.set(key, value);
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
	private static boolean isArray(Object object) {
		return object instanceof JSONArray;
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
	private static List<Object> convertToNativeArray(JSONArray array) {
		List<Object> objects = new ArrayList<>();

		for(Object object : array) {

			// Any array objects must be further simplified.
			if (isArray(object)) {
				objects.add(convertToNativeArray((JSONArray) object));
				continue;
			}

			objects.add(object);
		}

		return objects;
	}

}
