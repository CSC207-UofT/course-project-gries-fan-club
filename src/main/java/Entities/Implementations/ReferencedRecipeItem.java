package Entities.Implementations;

import Entities.Ingredient;
import Entities.RecipeItem;
import Entities.Reference.Reference;
import Storages.Exceptions.NoSuchEntity;

/**
 * A facade class for lazy loading of Recipe Items.
 */
public class ReferencedRecipeItem extends ReferencedEntity<RecipeItem> implements RecipeItem {

	public ReferencedRecipeItem(Reference<RecipeItem> reference) {
		super(reference);
	}

	@Override
	public Ingredient ingredient() {
		try {
			return this.entityReference.get().ingredient();
		} catch (NoSuchEntity noSuchEntity) {
			return null;
		}
	}

	@Override
	public float quantity() {
		try {
			return this.entityReference.get().quantity();
		} catch (NoSuchEntity noSuchEntity) {
			return 0;
		}
	}

	@Override
	public boolean optional() {
		try {
			return this.entityReference.get().optional();
		} catch (NoSuchEntity noSuchEntity) {
			return false;
		}
	}

	@Override
	public String display() {
		try {
			return this.entityReference.get().display();
		} catch (NoSuchEntity noSuchEntity) {
			return this.entityReference.id().toString();
		}
	}

	@Override
	public String serializeTypeCode() {
		try {
			return this.entityReference.get().serializeTypeCode();
		} catch (NoSuchEntity noSuchEntity) {
			return "";
		}
	}
}
