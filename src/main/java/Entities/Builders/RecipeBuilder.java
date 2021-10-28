package Entities.Builders;

import Entities.Recipe;
import Loaders.Row;
import Storages.Implementations.IngredientStorageImpl;

public class RecipeBuilder extends AbstractBuilder<Recipe> {

	private IngredientStorageImpl ingredientStorageImpl;

	RecipeBuilder(IngredientStorageImpl ingredientStorageImpl) {
		this.ingredientStorageImpl = ingredientStorageImpl;
	}

	@Override
	protected Recipe loadEntity(Row row) {
		return null;
	}

	@Override
	public String type() {
		return "recipe";
	}

}
