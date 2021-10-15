package Storages;

import EntityInterfaces.Ingredient;

public class IngredientStorage extends AbstractStorage<Ingredient> {

	@Override
	public String type() {
		return "Ingredient";
	}

}
