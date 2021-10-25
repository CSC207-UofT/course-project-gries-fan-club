package Loaders.Implementations;

import Loaders.Row;

import java.util.HashMap;
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

	@Override
	public <T> T get(String attribute, Class<? extends T> type) {
		return type.cast(this.attributes.get(attribute));
	}

}
