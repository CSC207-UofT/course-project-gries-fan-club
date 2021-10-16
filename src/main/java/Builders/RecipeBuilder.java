package Builders;

import EntityInterfaces.Recipe;
import LoaderInterfaces.Row;
import Storages.IngredientStorageImpl;

public class RecipeBuilder extends AbstractBuilder<Recipe> {

	private IngredientStorageImpl ingredientStorageImpl;

	RecipeBuilder(IngredientStorageImpl ingredientStorageImpl) {
		this.ingredientStorageImpl = ingredientStorageImpl;
	}

	@Override
	protected Recipe loadEntity(Row row) {
		String name = row.get("name", String.class);
		String description = row.get("description", String.class);
		return null;
	}

	@Override
	public String type() {
		return "recipe";
	}

}
