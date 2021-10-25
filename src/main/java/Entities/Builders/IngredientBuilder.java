package Entities.Builders;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.TagImpl;
import Entities.Ingredient;
import Entities.Tag;
import LoaderInterfaces.Row;

import java.util.ArrayList;
import java.util.List;

public class IngredientBuilder extends AbstractBuilder<Ingredient> {
	@Override
	protected Ingredient loadEntity(Row row) {
		String name = row.get("name", String.class);
		List rawTags = row.get("tags", List.class);

		List<Tag> tags = new ArrayList<>();
		for(Object tagName : rawTags) {
			tags.add(new TagImpl((String) tagName));
		}

		return new IngredientImpl(name, tags);
	}

	@Override
	public String type() {
		return "ingredient";
	}
}
