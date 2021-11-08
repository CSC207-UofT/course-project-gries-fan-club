package Loaders.Implementations;

import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A basic implementation of a row interface.
 */
public class RowImpl implements Row {

	private final String type;
	private Map<String, Object> attributes;

	public RowImpl(String type) {
		this.type = type;
		this.attributes = new HashMap<>();
	}

	public RowImpl(String type, Map<String, Object> attributes) {
		this(type);
		this.attributes = attributes;
	}

	/**
	 * Sets a given attribute to the given value.
	 *
	 * @param attribute The name of the attribute
	 * @param value The value to insert
	 * @param <T> The type of the value.
	 */
	public <T> void set(String attribute, T value) {
		this.attributes.put(attribute, value);
	}

	@Override
	public String type() {
		return this.type;
	}

	@Override
	public boolean empty() {
		return this.attributes.size() == 0;
	}

	/**
	 * This assumes that null values are missing values.
	 *
	 * @param attribute The name of the attribute
	 * @param type The class type for the attribute
	 *
	 * @return The attribute cast as type.
	 */
	@Override
	public <T> T get(String attribute, Class<? extends T> type) throws NoSuchAttribute {
		T obj = type.cast(this.attributes.get(attribute));

		// Throw an exception when the object is null.
		if (obj == null) {
			throw new NoSuchAttribute(attribute, type.toString());
		}

		return obj;
	}

	@Override
	public <T> List<T> getAsList(String attribute, Class<? extends T> type) throws NoSuchAttribute {
		List<T> asList = new ArrayList<>();

		// We must convert each object in this list.
		for(Object value : this.get(attribute, List.class)) {
			asList.add(type.cast(value));
		}

		return asList;
	}

	@Override
	public <T> Map<String, T> getAsMap(String attribute, Class<? extends T> type) throws NoSuchAttribute {
		Map<String, T> asMap = new HashMap<>();

		// We must convert each value in this object.
		Map<?, ?> rawMap = this.get(attribute, Map.class);
		for(Object key : rawMap.keySet()) {
			asMap.put((String) key, type.cast(rawMap.get(key)));
		}

		return asMap;
	}

}
