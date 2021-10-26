package Storages.Exceptions;

import java.util.UUID;

/**
 * A required entity was requested but not found.
 *
 * Note: this is not meant to indicate empty search results.
 * Instead, it is used when attempting to load a specific entity which could
 * not be completed.
 */
public class NoSuchEntity extends Exception {

	/**
	 * Includes the requested ID within the error message.
	 *
	 * @param id The ID whose entity could not be loaded.
	 */
	public NoSuchEntity(UUID id) {
		super("No such entity exists: ".concat(id.toString()));
	}

}
