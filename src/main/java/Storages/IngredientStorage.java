package Storages;

import Entities.Ingredient;
import Entities.Tag;

import java.util.Collection;

public interface IngredientStorage extends Storage<Ingredient> {
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
	 * @param name The name or regex to match
	 *
	 * @return All matched ingredients
	 */
	Collection<Ingredient> findByName(String name);

	/**
	 * Finds an ingredient if it exactly matches one name.
	 * Similar to the findByName but only returns one value.
	 */

	Collection<Ingredient> findByNameExact(String name);


	/**
	 * Finds all ingredients that include all the given tags.
	 *
	 * @param tags The tags to match
	 *
	 * @return All matched ingredients
	 */
	Collection<Ingredient> findByTags(Collection<Tag> tags);

}
