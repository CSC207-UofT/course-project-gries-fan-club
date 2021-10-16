package Loaders;

import LoaderInterfaces.Loader;
import LoaderInterfaces.Row;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Loads data from JSON format.
 */
public class JSONLoader implements Loader {

	private final JSONArray source;
	private int index = 0;

	public JSONLoader(JSONArray source) {
		this.source = source;
	}

	public JSONLoader(String source) {
		this.source = new JSONArray(source);
	}

	@Override
	public Row readRow() {
		if (!this.validIndex()) {
			return new EmptyRow();
		}

		JSONObject currentObject = this.source.getJSONObject(this.index++);
		String rowType = currentObject.getString("type");

		RowImpl row = new RowImpl(rowType);

		for(String key : currentObject.keySet()) {
			if (key.equals("type")) {
				// Do not add the type key as an attribute.
				continue;
			}

			Object value = currentObject.get(key);

			if(isArray(value)) {
				// We do not want to return JSONArrays outside this class.
				value = flattenArray((JSONArray) value);
			}

			row.set(key, value);
		}

		return row;
	}

	@Override
	public void resetReader() {
		this.index = 0;
	}

	/**
	 * Determines if the current index is valid for our source.
	 *
	 * Note, this assumes that the index is greater than or equal to zero.
	 * This should always be the case within this class.
	 *
	 * @return Whether the index is valid
	 */
	private boolean validIndex() {
		return this.index < this.source.length();
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

	private static List<Object> flattenArray(JSONArray array) {
		List<Object> objects = new ArrayList<>();

		for(Object object : array) {
			if (isArray(object)) {
				objects.add(flattenArray((JSONArray) object));
				continue;
			}

			objects.add(object);
		}

		return objects;
	}

}
