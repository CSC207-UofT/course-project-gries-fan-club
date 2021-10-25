package Storages;

import Entities.Ingredient;
import Entities.Recipe;
import Entities.Tag;

import java.util.Collection;
import java.util.List;

public interface RecipeStorage {

	/**
	 * All the recipes stored within.
	 *
	 * @return A collection of recipes
	 */
	Collection<Recipe> recipes();

	/**
	 * Finds a recipes that match a given name.
	 * Regular expressions can also be provided.
	 *
	 * @param name The name or regular expression to match
	 *
	 * @return All matched recipes
	 */
	Collection<Recipe> find(String name);

	/**
	 * Finds all recipes that include all the given tags.
	 *
	 * @param tags The tags to match
	 *
	 * @return All matched recipes
	 */
	Collection<Recipe> find(Collection<Tag> tags);

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
	Collection<Recipe> find(List<Ingredient> ingredients);

}
