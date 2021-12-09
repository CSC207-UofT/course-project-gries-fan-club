package Entities.Builders;

import Entities.Exceptions.InvalidRowShape;
import Entities.Implementations.QuantityRecipeItem;
import Entities.Implementations.ReferencedIngredient;
import Entities.Implementations.VolumetricRecipeItem;
import Entities.Ingredient;
import Entities.RecipeItem;
import Entities.Reference.Reference;
import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;
import Storages.Storage;

import java.util.UUID;

/**
 * Defines creation of recipe item entities.
 *
 * Rows for this builder require the shape (key: value type [description]):
 *   - id: String (Must represent a UUID)
 *   - ingredient: String (Must represent an ingredients UUID)
 *   - quantity: Double
 *   - optional: Boolean
 *   - type: String (the type of recipe item that should be constructed.
 *   	 should be one of "q", "v".)
 */
public class RecipeItemBuilder extends AbstractBuilder<RecipeItem> {

	private final Storage<Ingredient> ingredientStorage;

	/**
	 * Provides the ingredient storage to reference ingredients from.
	 *
	 * @param storage The storage
	 */
	public RecipeItemBuilder(Storage<Ingredient> storage) {
		this.ingredientStorage = storage;
	}

	@Override
	public RecipeItem loadEntity(Row row) throws InvalidRowShape {

		String rawID;
		String rawIngredientID;
		double quantity;
		boolean optional;
		String type;
		String displayType;

		try {
			// Attempt to retrieve required data.
			rawID = row.get("id", String.class);
			rawIngredientID = row.get("ingredient", String.class);
			quantity = row.get("quantity", Number.class).doubleValue();
			optional = row.get("optional", Boolean.class);
			displayType = row.get("displayType", String.class);

		} catch (NoSuchAttribute exception) {
			throw new InvalidRowShape("RecipeItem", exception);
		}

		// Create the proper objects for construction.
		UUID id = UUID.fromString(rawID);
		UUID ingredientID = UUID.fromString(rawIngredientID);

		Reference<Ingredient> ingredientReference = new Reference<>(ingredientID, this.ingredientStorage);
		Ingredient ingredient = new ReferencedIngredient(ingredientReference);

		// Determine the type of recipe item to make.
		switch (displayType) {
			case "q":
				return new QuantityRecipeItem(id, ingredient, quantity, optional);
			case "v":
				return new VolumetricRecipeItem(id, ingredient, quantity, optional);
			case "m":
				return new QuantityRecipeItem(id, ingredient, quantity, optional);
		}

		// An invalid type was stored, this row is considered invalid.
		throw new InvalidRowShape("An invalid type: \"" + displayType + "\" was specified for a RecipeItem.");
	}

	@Override
	public String type() {
		return "recipeItem";
	}
}
