package UseCases;

import java.util.List;
import java.util.UUID;

public class FridgeImpl implements Fridge {
	// store the ingredients ids here not the actual ingredients
	List<UUID> ingredientIds;

	public FridgeImpl(List<UUID> ids) {
		this.ingredientIds = ids;
	}

	/**
	 * Add a new ingredient ID to this storage
	 * @param ingredientID ingredient id wanting to be added
	 */
	@Override
	public void add(UUID ingredientID) {
		this.ingredientIds.add(ingredientID);
	}

	@Override
	public List<UUID> allIngredientsByID() {
		return this.ingredientIds;
	}

}
