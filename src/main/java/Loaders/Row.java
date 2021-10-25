package Loaders;

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
	 * Retrieves the given attribute as a given type.
	 *
	 * @param attribute The name of the attribute
	 * @param type The class type for the attribute
	 *
	 * @return The attribute cast as type
	 */
	<T> T get(String attribute, Class<? extends T> type);

}
