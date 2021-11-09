package Entities.Builders;

import Entities.Exceptions.InvalidRowShape;
import Entities.Implementations.QuantityRecipeItem;
import Entities.Implementations.RecipeImpl;
import Entities.Implementations.ReferencedIngredient;
import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Reference.Reference;
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
 *   - optionalItems: Map<String, Double> (This is the same as above)
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
		Map<String, Double> rawRequiredItems;
		Map<String, Double> rawOptionalItems;

		try {

			rawID = row.get("id", String.class);
			name = row.get("name", String.class);
			description = row.get("description", String.class);

			instructions = row.getAsList("instructions", String.class);
			rawRequiredItems = row.getAsMap("items", Double.class);
			rawOptionalItems = row.getAsMap("optionalItems", Double.class);

		} catch (NoSuchAttribute exception) {
			throw new InvalidRowShape("Recipe", exception);
		}

		// Create needed objects' tp build our recipe.
		UUID id = UUID.fromString(rawID);

		List<RecipeItem> items = new ArrayList<>();

		// First add the required items.
		for (String key : rawRequiredItems.keySet()) {
			items.add(this.createItemWithReference(
							UUID.fromString(key),
							rawRequiredItems.get(key).floatValue(),
							false
			));
		}

		// Then add optional items.
		for (String key : rawOptionalItems.keySet()) {
			items.add(this.createItemWithReference(
							UUID.fromString(key),
							rawOptionalItems.get(key).floatValue(),
							true
			));
		}

		return new RecipeImpl(id, name, description, instructions, items);
	}

	@Override
	public String type() {
		return "recipe";
	}

	/**
	 * Constructs a recipe item and ingredient reference.
	 *
	 * @param ingredientID The UUID of the ingredient the item references
	 * @param quantity The quantity of the item
	 * @param optional Whether this ingredient is optional
	 *
	 * @return The constructed recipe item
	 */
	private RecipeItem createItemWithReference(UUID ingredientID, float quantity, boolean optional) {

		// Create a reference to the needed ingredients.
		Reference<Ingredient> reference = new Reference<>(
						ingredientID,
						this.ingredientStorage
		);
		Ingredient ingredient = new ReferencedIngredient(reference);

			// @Todo, why does this not take floats!?
			items.add((RecipeItem) new QuantityRecipeItem(ingredient, rawItems.get(key).floatValue(), false));
		}

		return new RecipeImpl(id, name, description, instructions, items);
	}

	@Override
	public String type() {
		return "recipe";
	}

}
