package Entities.Builders;

import Entities.Exceptions.InvalidRowShape;
import Entities.Implementations.RecipeImpl;
import Entities.Implementations.ReferencedRecipeItem;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Reference.Reference;
import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;
import Storages.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Defines creation of recipe entities.
 *
 * Rows for this builder require the shape (key: value type [description]):
 *   - id: String (Must represent a UUID)
 *   - name: String
 *   - description: String
 *   - instructions: List<String>
 *   - items: List<String> (Must represent the UUID of recipeItems)
 */
public class RecipeBuilder extends AbstractBuilder<Recipe> {

	private final Storage<RecipeItem> itemStorage;

	public RecipeBuilder(Storage<RecipeItem> itemStorage) {
		this.itemStorage = itemStorage;
	}

	@Override
	public Recipe loadEntity(Row row) throws InvalidRowShape {
		String rawID;
		String name;
		String description;

		List<String> instructions;
		List<String> rawItems;

		try {

			rawID = row.get("id", String.class);
			name = row.get("name", String.class);
			description = row.get("description", String.class);

			instructions = row.getAsList("instructions", String.class);
			rawItems = row.getAsList("items", String.class);

		} catch (NoSuchAttribute exception) {
			throw new InvalidRowShape("Recipe", exception);
		}

		// Create needed objects' tp build our recipe.
		UUID id = UUID.fromString(rawID);

		// Create Recipe Item references.
		List<RecipeItem> items = new ArrayList<>();
		for (String itemID : rawItems) {
			Reference<RecipeItem> reference = new Reference<>(UUID.fromString(itemID), this.itemStorage);
			items.add(new ReferencedRecipeItem(reference));
		}

		return new RecipeImpl(id, name, description, instructions, items);
	}

	@Override
	public String type() {
		return "recipe";
	}
}
