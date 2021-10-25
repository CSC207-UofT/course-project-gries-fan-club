package Loaders.Implementations;

import Loaders.Row;

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
	public <T> T get(String attribute, Class<? extends T> type) {
		return null;
	}
}
