package Entities.Builders;

import Entities.Exceptions.InvalidRowShape;
import Entities.Implementations.RecipeImpl;
import Entities.Implementations.RecipeItemImpl;
import Entities.Implementations.ReferencedIngredient;
import Entities.Implementations.ReferencedTag;
import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Reference.Reference;
import Entities.Tag;
import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;
import Storages.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Defines creation of recipe entities.
 *
 * Rows for this builder require the shape (key: value type [description]):
 *   - id: String (Must represent a UUID)
 *   - name: String
 *   - description: String
 *   - instructions: List<String>
 *   - items: Map<String, Double> (Where the key is the UUID representation of
 *   		an Ingredient's ID, and the value is the quantity for the item)
 */
public class RecipeBuilder extends AbstractBuilder<Recipe> {

	private final Storage<Ingredient> ingredientStorage;

	RecipeBuilder(Storage<Ingredient> ingredientStorage) {
		this.ingredientStorage = ingredientStorage;
	}

	@Override
	protected Recipe loadEntity(Row row) throws InvalidRowShape {
		String rawID;
		String name;
		String description;

		List<String> instructions;
		Map<String, Double> rawItems;

		try {

			rawID = row.get("id", String.class);
			name = row.get("name", String.class);
			description = row.get("description", String.class);

			instructions = row.getAsList("instructions", String.class);
			rawItems = row.getAsMap("items", Double.class);

		} catch (NoSuchAttribute exception) {
			throw new InvalidRowShape("Recipe", exception);
		}

		// Create needed objects' tp build our recipe.
		UUID id = UUID.fromString(rawID);

		List<RecipeItem> items = new ArrayList<>();
		for (String key : rawItems.keySet()) {

			// Create a reference to the needed ingredients.
			Reference<Ingredient> reference = new Reference<>(
							UUID.fromString(key),
							this.ingredientStorage
			);
			Ingredient ingredient = new ReferencedIngredient(reference);

			// @Todo, why does this not take floats!?
			items.add(new RecipeItemImpl(ingredient, rawItems.get(key).intValue()));
		}

		return new RecipeImpl(id, name, description, instructions, items);
	}

	@Override
	public String type() {
		return "recipe";
	}

}
