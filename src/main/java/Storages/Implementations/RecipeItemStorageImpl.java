package Storages.Implementations;

import Entities.RecipeItem;

public class RecipeItemStorageImpl extends AbstractStorage<RecipeItem> {
	@Override
	public String type() {
		return "recipeItem";
	}
}
