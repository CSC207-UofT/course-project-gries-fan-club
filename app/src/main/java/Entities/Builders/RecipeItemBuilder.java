package Entities.Builders;

import Entities.Exceptions.InvalidRowShape;
import Entities.Implementations.RecipeItemImpl;
import Entities.Implementations.ReferencedIngredient;
import Entities.Ingredient;
import Entities.RecipeItem;
import Entities.Reference.Reference;
import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;
import RecipeItemDisplayers.*;
import Storages.Storage;
import Entities.RecipeItemDisplay;

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
		Double rawQuantity;
		boolean optional;
		String type;

		try {

			// Attempt to retrieve required data.
			rawID = row.get("id", String.class);
			rawIngredientID = row.get("ingredient", String.class);
			rawQuantity = row.get("quantity", Double.class);
			optional = row.get("optional", Boolean.class);
			type = row.get("type", String.class);

		} catch (NoSuchAttribute exception) {
			throw new InvalidRowShape("RecipeItem", exception);
		}

		// Create the proper objects for construction.
		UUID id = UUID.fromString(rawID);
		UUID ingredientID = UUID.fromString(rawIngredientID);
		float quantity = rawQuantity.floatValue();

		Reference<Ingredient> ingredientReference = new Reference<>(ingredientID, this.ingredientStorage);
		Ingredient ingredient = new ReferencedIngredient(ingredientReference);

		// Determine the type of recipe item to make.
		RecipeItemDisplay typeOfRecipe;
		switch (type) {
			case "q":
				typeOfRecipe = new Quantifiable();
				break;
			case "v":
				typeOfRecipe = new Volumetric();
				break;
			case "m":
				typeOfRecipe = new Mass();
				break;
			default:
				throw new InvalidRowShape("An invalid type: \"" + type + "\" was specified for a RecipeItem.");
		}
		return new RecipeItemImpl(id, ingredient, quantity, optional, typeOfRecipe);

		// An invalid type was stored, this row is considered invalid.

	}

	@Override
	public String type() {
		return "recipeItem";
	}
}
