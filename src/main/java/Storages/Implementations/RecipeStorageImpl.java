package Storages.Implementations;

import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Tag;
import Storages.RecipeStorage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeStorageImpl extends AbstractStorage<Recipe> implements RecipeStorage {
	@Override
	public String type() {
		return "recipe";
	}

	@Override
	public Collection<Recipe> recipes() { return this.entities.values(); }

	@Override
	public Collection<Recipe> findByName(String name) {
		Collection<Recipe> found = new ArrayList<>();

		for (Recipe recipe : this.recipes()) {
			if (recipe.name().matches(name)) {
				found.add(recipe);
			}
		}

		return found;
	}

	@Override
	public Collection<Recipe> findByTags(Collection<Tag> tags) {
		Collection<Recipe> found = new ArrayList<>();

		for (Recipe recipe : this.recipes()) {

			// If the given tags are a super set of the recipe's tags it should be counted.
			if (tags.containsAll(recipe.tags())) {
				found.add(recipe);
			}

		}

		return found;
	}

	@Override
	public Collection<Recipe> findByIngredients(List<Ingredient> ingredients) {
		Collection<Recipe> found = new ArrayList<>();

		for (Recipe recipe : this.recipes()) {

			// Gather all required ingredients.
			List<Ingredient> requiredIngredients = recipe.items(false)
							.stream()
							.map(RecipeItem::ingredient)
							.collect(Collectors.toList());

			// Add the recipe if it contains a subset of the given ingredients.
			if (ingredients.containsAll(requiredIngredients)) {
				found.add(recipe);
			}

		}

		return found;
	}
}
