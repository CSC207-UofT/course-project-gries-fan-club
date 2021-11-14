package Loaders;

import java.io.Writer;
import java.util.Collection;

/**
 * Defines a method of placing rows into persistent storage.
 */
public interface RowWriter {

	/**
	 * Saves the given rows to persistent storage.
	 *
	 * @param rows The rows to save
	 *
	 * @throws Exception When the data could not be saved.
	 */
	void save(Collection<Row> rows, Writer writeTo) throws Exception;

}
