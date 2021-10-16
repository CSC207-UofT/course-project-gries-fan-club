package Builders;

import EntityInterfaces.Recipe;
import LoaderInterfaces.Row;
import Storages.IngredientStorage;

public class RecipeBuilder extends AbstractBuilder<Recipe> {

	private IngredientStorage ingredientStorage;

	RecipeBuilder(IngredientStorage ingredientStorage) {
		this.ingredientStorage = ingredientStorage;
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
