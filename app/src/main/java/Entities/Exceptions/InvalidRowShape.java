package Entities.Exceptions;

/**
 * This is thrown when a row was given that does not have a required shape.
 *
 * For instance, a consumer requires that rows have a key "a" associated
 * with a 'Boolean' value.
 * If a row is given that does not have this attribute of the correct type,
 * then this exception might be thrown as a response.
 */
public class InvalidRowShape extends Exception {

	public InvalidRowShape(String message) {
		super(message);
	}

	public InvalidRowShape(String desiredEntity, Throwable cause) {
		super("The given row was not a valid " + desiredEntity, cause);
	}

}
