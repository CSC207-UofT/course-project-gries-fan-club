package Storages;

import EntityInterfaces.Recipe;

public class RecipeStorage extends AbstractStorage<Recipe> {

    /**
     * Constructs a RecipeStorage with given list of recipes
     * @param recipes       List of recipes
     **/
	@Override
	public String type() {
		return "recipe";
	}

}
