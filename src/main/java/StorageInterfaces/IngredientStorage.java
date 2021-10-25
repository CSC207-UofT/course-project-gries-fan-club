package StorageInterfaces;

import Entities.Ingredient;
import Entities.Tag;

import java.util.Collection;

public interface IngredientStorage {

	/**
	 * All the recipes stored within.
	 *
	 * @return A collection of ingredients
	 */
	Collection<Ingredient> ingredients();

	/**
	 * Finds all ingredients that match the given name.
	 * Regular expressions can also be provided.
	 *
	 * @param name The name or regular expression to match
	 *
	 * @return All matched ingredients
	 */
	Collection<Ingredient> find(String name);

	/**
	 * Finds all ingredients that include all the given tags.
	 *
	 * @param tags The tags to match
	 *
	 * @return All matched ingredients
	 */
	Collection<Ingredient> find(Collection<Tag> tags);

}
