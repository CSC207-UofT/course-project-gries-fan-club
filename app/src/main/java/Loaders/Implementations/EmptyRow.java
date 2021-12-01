package Loaders.Implementations;

import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Defines an empty row, that is a row with no type or data.
 *
 * This is defined to help save space when returning rows with no data.
 */
public class EmptyRow implements Row {

	@Override
	public String type() {
		return "";
	}

	@Override
	public boolean empty() {
		return true;
	}

	@Override
	public Collection<String> keySet() {
		return Collections.emptyList();
	}

	@Override
	public <T> T get(String attribute, Class<? extends T> type) throws NoSuchAttribute {
		throw new NoSuchAttribute(attribute, type.toString());
	}

	@Override
	public <T> List<T> getAsList(String attribute, Class<? extends T> type) throws NoSuchAttribute {
		throw new NoSuchAttribute(attribute, "List of " + type.toString());
	}

	@Override
	public <T> Map<String, T> getAsMap(String attribute, Class<? extends T> type) throws NoSuchAttribute {
		throw new NoSuchAttribute(attribute, "Map of " + type.toString());
	}
}
