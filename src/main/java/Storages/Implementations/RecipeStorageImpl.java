package Storages.Implementations;

import Entities.*;
import Matchers.Implementations.TagMatcher;
import Storages.IngredientStorage;
import Storages.RecipeStorage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecipeStorageImpl extends AbstractStorage<Recipe> implements RecipeStorage {
	@Override
	public String type() {
		return "recipe";
	}

	@Override
	public Collection<Recipe> recipes() { return this.entities.values(); }

	@Override
	public Collection<Recipe> findByName(String name) {
		//Regexes to be added later
		Collection<Recipe> found = new ArrayList<>();
		for (Recipe recipe : this.recipes()) {
			if (recipe.name().contains(name))
				found.add(recipe);
		}
		return found;
	}

	@Override
	public Collection<Recipe> findByTags(Collection<Tag> tags) {
		Collection<Recipe> found = new ArrayList<>();
		TagMatcher t = new TagMatcher((List<Tag>) tags); //Use a tag matcher
		for (Recipe recipe : this.recipes()) {
			if (t.matches(recipe))
				found.add(recipe);
		}
		return found;
	}

	@Override
	public Collection<Recipe> findByIngredients(List<Ingredient> ingredients) {
		Collection<Recipe> found = new ArrayList<>();
		for (Recipe recipe : this.recipes()) {
			List<Ingredient> ingredientList = new ArrayList<>();
			for (RecipeItem item : recipe.items())
				ingredientList.add(item.ingredient());
			if (ingredientList.contains(ingredients))
				found.add(recipe);
		}
		return found;
	}
}
