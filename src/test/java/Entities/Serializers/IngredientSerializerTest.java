package Entities.Serializers;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.TagImpl;
import Entities.Ingredient;
import Entities.Tag;
import Loaders.Exceptions.NoSuchAttribute;
import Loaders.Row;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class IngredientSerializerTest {

	@Test
	public void testSerializeEntity() throws NoSuchAttribute {
		Tag tag = new TagImpl("orange");
		Ingredient ingredient = new IngredientImpl("carrot", List.of(tag));

		IngredientSerializer serializer = new IngredientSerializer();
		Row row = serializer.serializeEntity(ingredient);

		Assertions.assertEquals("ingredient", row.type());
		Assertions.assertEquals(ingredient.id().toString(), row.get("id", String.class));
		Assertions.assertEquals(ingredient.name(), row.get("name", String.class));

		List<String> tags = row.getAsList("tags", String.class);
		Assertions.assertEquals(1, tags.size());
		Assertions.assertEquals(tag.id().toString(), tags.get(0));
	}

}
