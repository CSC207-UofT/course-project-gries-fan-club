package Entities.Builders;

import Entities.Exceptions.InvalidRowShape;
import Entities.Implementations.TagImpl;
import Entities.Tag;
import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;

import java.util.UUID;

/**
 * Defines the creation of tag entities.
 *
 * Rows for this builder require the shape (key: type [description]):
 *   - id: String (must be a valid UUID)
 *   - name: String
 */
public class TagBuilder extends AbstractBuilder<Tag> {

	/**
	 * Creates a Tag entity from its ID and a name.
	 *
	 * @param row The row representing the entity
	 *
	 * @return The built Tag
	 *
	 * @throws InvalidRowShape If either the name or ID is missing.
	 */
	@Override
	public Tag loadEntity(Row row) throws InvalidRowShape {

		String rawID;
		String name;

		try {

			rawID = row.get("id", String.class);
			name = row.get("name", String.class);

		} catch (NoSuchAttribute exception) {

			throw new InvalidRowShape("Tag", exception);

		}

		// Construct and return the tag.
		UUID id = UUID.fromString(rawID);

		return new TagImpl(id, name);

	}

	@Override
	public String type() {
		return "tag";
	}
}
