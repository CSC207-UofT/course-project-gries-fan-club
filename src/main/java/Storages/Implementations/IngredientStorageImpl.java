package Storages.Implementations;

import Entities.Ingredient;
import Entities.Tag;
import Storages.IngredientStorage;

import java.util.ArrayList;
import java.util.Collection;

public class IngredientStorageImpl extends AbstractStorage<Ingredient> implements IngredientStorage {

	@Override
	public String type() {
		return "ingredient";
	}

	@Override
	public Collection<Ingredient> ingredients() {
		return this.entities.values();
	}

	@Override
	public Collection<Ingredient> findByName(String name) {
		//REGEXES to be added later
		Collection<Ingredient> found = new ArrayList<>();

		for (Ingredient ingredient : this.ingredients()) {
			if (ingredient.name().contains(name))
				found.add(ingredient);
		}
	return found;
	}

	@Override
	public Collection<Ingredient> findByTags(Collection<Tag> tags) {

		Collection<Ingredient> found = new ArrayList<>();

		for (Tag tag: tags) {
			for (Ingredient ingredient : this.ingredients()) {
				if (ingredient.has(tag)) {
					found.add(ingredient);
				}
			}
		}

		return found;
	}
}
