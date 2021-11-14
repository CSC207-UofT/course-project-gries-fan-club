package Storages.Implementations;

import Entities.Ingredient;
import Entities.Tag;
import Storages.IngredientStorage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class IngredientStorageImpl extends AbstractStorage<Ingredient> implements IngredientStorage {

	@Override
	public String type() {
		return "ingredient";
	}

	@Override
	public Collection<Ingredient> ingredients() {
		return this.entities.values();
	}

	/**
	 * Find the ingredients that contain the string given
	 *
	 * @param name The name or regex to match
	 *
	 * @return Collection of ingredients that match that name
	 */
	@Override
	public Collection<Ingredient> findByName(String name) {
		Collection<Ingredient> found = new ArrayList<>();

		for (Ingredient ingredient : this.ingredients()) {
			if (ingredient.name().contains(name)) {
				found.add(ingredient);
			}
		}

		// will return empty if there is nothing found
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
	@Override
	public Collection<Ingredient> findByNameExact(String name) {
		Collection<Ingredient> found = new ArrayList<>();

		for (Ingredient ingredient : this.ingredients()) {
			if (Objects.equals(ingredient.name(), name)) {
				found.add(ingredient);
				return found;
			}
		}
		// will return empty if there is nothing found
		return found;
	}
}
