package Loaders;

import LoaderInterfaces.Loader;
import LoaderInterfaces.Row;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Set;

/**
 * Loads data from JSON format.
 */
public class JSONLoader implements Loader {

	private final JSONArray source;
	private int index = 0;

	JSONLoader(JSONArray source) {
		this.source = source;
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

			row.set(key, currentObject.get(key));
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

}
