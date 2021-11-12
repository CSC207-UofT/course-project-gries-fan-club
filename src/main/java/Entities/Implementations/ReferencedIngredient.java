package Entities.Implementations;

import Entities.Ingredient;
import Entities.Reference.Reference;
import Entities.Tag;
import Storages.Exceptions.NoSuchEntity;

import java.util.List;

public class ReferencedIngredient extends ReferencedEntity<Ingredient> implements Ingredient {

	public ReferencedIngredient(Reference<Ingredient> entityReference) {
		super(entityReference);
	}

	@Override
	public List<Tag> tags() {
		try {
			return this.entityReference.get().tags();
		} catch (NoSuchEntity e) {
			return null;
		}
	}

	@Override
	public boolean has(Tag tag) {
		try {
			return this.entityReference.get().has(tag);
		} catch (NoSuchEntity e) {
			return false;
		}
	}

	@Override
	public String name() {
		try {
			return this.entityReference.get().name();
		} catch (NoSuchEntity e) {
			return this.entityReference.id().toString();
		}
	}
}
