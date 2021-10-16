package Storages;

import EntityInterfaces.Ingredient;
import EntityInterfaces.Recipe;
import EntityInterfaces.Tag;
import StorageInterfaces.RecipeStorage;

import java.util.Collection;
import java.util.List;

public class RecipeStorageImpl extends AbstractStorage<Recipe> implements RecipeStorage {

	@Override
	public String type() {
		return "recipe";
	}

	@Override
	public Collection<Recipe> recipes() {
		return null;
	}

	@Override
	public Collection<Recipe> find(String name) {
		return null;
	}

	@Override
	public Collection<Recipe> find(Collection<Tag> tags) {
		return null;
	}

	@Override
	public Collection<Recipe> find(List<Ingredient> ingredients) {
		return null;
	}
}
