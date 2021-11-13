package Storages;

import Entities.Entity;
import Entities.Ingredient;
import Entities.Recipe;
import Entities.Tag;

import java.util.Collection;
import java.util.List;
	public interface RecipeStorage extends Storage<Recipe> {

	/**
	 * All the recipes stored within.
	 *
	 * @return A collection of recipes
	 */
	Collection<Recipe> recipes();

	/**
	 * Finds recipe(s) that match a given name.
	 * Regular expressions can also be provided.
	 *
	 * @param name The name or regex to match
	 *
	 * @return All matched recipes
	 */
	Collection<Recipe> findByName(String name);

	/**
	 * Finds all recipes that include all the given tags.
	 *
	 * @param tags The tags to match
	 *
	 * @return All matched recipes
	 */
	Collection<Recipe> findByTags(Collection<Tag> tags);

	/**
	 * Finds all recipes that contain use a subset of the given ingredients.
	 * If a recipe has an ingredient marked as optional it will not matter if that ingredient is in the matching list.
	 *
	 * Note: the use of List here is hopefully temporary as we must avoid errors with type erasure.
	 *
	 * @param ingredients The list of ingredients to match
	 *
	 * @return All matched recipes
	 */
	Collection<Recipe> findByIngredients(List<Ingredient> ingredients);

}
