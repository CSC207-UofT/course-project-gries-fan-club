package LoaderInterfaces;

public interface Loader {

	/**
	 * Returns a new row of data.
	 *
	 * @return The next row, or an empty row if there are no more rows.
	 */
	Row readRow();

	/**
	 * Resets the loader to read from the start of source data.
	 */
	void resetReader();

}
