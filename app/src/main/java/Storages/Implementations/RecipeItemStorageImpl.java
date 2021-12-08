package Storages.Implementations;

import Entities.RecipeItem;
import Storages.RecipeItemStorage;

public class RecipeItemStorageImpl extends AbstractStorage<RecipeItem> implements RecipeItemStorage {
	@Override
	public String type() {
		return "recipeItem";
	}
}
