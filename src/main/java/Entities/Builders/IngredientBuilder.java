package Entities.Builders;

import Entities.Exceptions.InvalidRowShape;
import Entities.Implementations.IngredientImpl;
import Entities.Implementations.ReferencedTag;
import Entities.Ingredient;
import Entities.Reference.Reference;
import Entities.Tag;
import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;
import Storages.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Defines the creation of ingredient entities.
 *
 * Rows for this builder require the shape (key: type [description]):
 *   - id: String (must be a valid UUID)
 *   - name: String
 *   - tags: List<String> (represents the tags UUID)
 */
public class IngredientBuilder extends AbstractBuilder<Ingredient> {
	private final Storage<Tag> tagStorage;

	/**
	 * The ingredient builder requires a TagStorage.
	 *
	 * @param tagStorage The tagStorage to use.
	 */
	public IngredientBuilder(Storage<Tag> tagStorage) {
		this.tagStorage = tagStorage;
	}

	/**
	 * Ingredients only need tag references added.
	 *
	 * @param row The row representing the entity
	 *
	 * @return The built ingredient
	 */
	@Override
	protected Ingredient loadEntity(Row row) throws InvalidRowShape {
		String rawID;
		String name;
		List<?> tagIDs;

		try {

			// Attempt retrieval of required data.
			rawID = row.get("id", String.class);
			name = row.get("name", String.class);
			tagIDs = row.get("tags", List.class);

		} catch (NoSuchAttribute noSuchAttribute) {

			// Rethrow the error as an invalid row error.
			throw new InvalidRowShape("Ingredient", noSuchAttribute);

		}

		// Construct references from the tag ID's.
		List<Tag> tags = new ArrayList<>();
		for(Object idObject : tagIDs) {
			String tagID = (String) idObject;

			Reference<Tag> reference = new Reference<>(
							UUID.fromString(tagID),
							this.tagStorage
			);
			tags.add(new ReferencedTag(reference));
		}

		UUID id = UUID.fromString(rawID);
		return new IngredientImpl(id, name, tags);
	}

	@Override
	public String type() {
		return "ingredient";
	}

}
