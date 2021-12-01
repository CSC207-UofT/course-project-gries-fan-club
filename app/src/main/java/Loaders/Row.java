package Loaders;

import Loaders.Exceptions.NoSuchAttribute;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Row {

	/**
	 * The type of entity contained within this row.
	 *
	 * @return the string name of the type.
	 */
	String type();

	/**
	 * Determines whether the row contains any data.
	 *
	 * @return whether the row is empty.
	 */
	boolean empty();

	/**
	 * Returns the keys of all attributes in this row.
	 *
	 * @return a list of keys.
	 */
	 Collection<String> keySet();

	/**
	 * Retrieves the given attribute as a given type.
	 *
	 * @param attribute The name of the attribute
	 * @param type The class type for the attribute
	 *
	 * @return The attribute cast as type
	 *
	 * @throws NoSuchAttribute When the requested attribute could not be found.
	 */
	<T> T get(String attribute, Class<? extends T> type) throws NoSuchAttribute;

	/**
	 * Retrieves an attribute specifically as a list of a given type.
	 *
	 * This is in place to assist with type erasure of parameterized classes
	 * within the `get` function.
	 *
	 * @param attribute The name of the attribute
	 * @param type The type of object the list should contain
	 *
	 * @return The attribute as a list of the given type.
	 *
	 * @throws NoSuchAttribute When the requested attribute could not be found.
	 */
	<T> List<T> getAsList(String attribute, Class<? extends T> type) throws NoSuchAttribute;

	/**
	 * Retrieves an attribute specifically as a Map of strings to a given type.
	 *
	 * This is in place to assist with type erasure of parameterized classes
	 * within the `get` function.
	 *
	 * @param attribute The name of the attribute
	 * @param type The type of object the Map should contain
	 *
	 * @return The attribute as a Map of strings to the given type.
	 *
	 * @throws NoSuchAttribute When the requested attribute could not be found.
	 */
	<T> Map<String, T> getAsMap(String attribute, Class<? extends T> type) throws NoSuchAttribute;

}
