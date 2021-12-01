package Loaders.Exceptions;

/**
 * Thrown when an attribute with the provided key and type does not exist.
 */
public class NoSuchAttribute extends Exception {

	public NoSuchAttribute() {
		super("A requested attribute could not be found.");
	}

	/**
	 * Creates a message relaying information on the requested attribute.
	 *
	 * @param key The key of the attribute in question.
	 * @param type The requested type of the attribute.
	 */
	public NoSuchAttribute(String key, String type) {
		super(String.format(
						"The attribute: \"%s\" with type: \"%s\" could not be found.",
						key,
						type
		));
	}

}
