package Builders;

import EntityInterfaces.Recipe;
import LoaderInterfaces.Row;

public class RecipeBuilder extends AbstractBuilder<Recipe> {

	@Override
	protected Recipe loadEntity(Row row) {
		return null;
	}

	@Override
	public String type() {
		return "Recipe";
	}

}
