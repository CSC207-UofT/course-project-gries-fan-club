package Matcher;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.QuantityRecipeItem;
import Entities.Implementations.RecipeImpl;
import Entities.Implementations.TagImpl;
import Entities.Ingredient;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Tag;
import Matchers.Implementations.TagMatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TagMatcherTest {

    /**
     * Defines the setup for easier testing
     */

    @Test
    public void testMatchesTrue() {
        // Tag list
        TagImpl tag1 = new TagImpl("Dairy");
        TagImpl tag2 = new TagImpl("Gluten");

        List<Tag> tags = new ArrayList<>();
        tags.add(tag1);

        List<Tag> list = new ArrayList<>();
        list.add(tag1);
        list.add(tag2);

        // Recipe
        IngredientImpl ingredient1 = new IngredientImpl("bread", list);
        RecipeItem item = new QuantityRecipeItem(ingredient1, 15, false);
        List<RecipeItem> recipeItems = new ArrayList<>();
        recipeItems.add(item);
        RecipeImpl recipe = new RecipeImpl("name", "description", List.of("instructions"), recipeItems);

        // AbstractMatcher
        TagMatcher matcher = new TagMatcher(tags);
        Assertions.assertTrue(matcher.matches(recipe));
    }

    @Test
    public void testMatchesFalse() {
        // Tag list
        Tag tag1 = new TagImpl("Dairy");
        Tag tag2 = new TagImpl("Gluten");

        List<Tag> tags = new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);

        List<Tag> list = new ArrayList<>();
        list.add(tag1);

        // Recipe
        Ingredient ingredient1 = new IngredientImpl("bread", list);
        RecipeItem item = new QuantityRecipeItem(ingredient1, 15, false);
        List<RecipeItem> recipeItems = new ArrayList<>();
        recipeItems.add(item);
        Recipe recipe = new RecipeImpl("name", "description", Collections.singletonList("instructions"), recipeItems);

        TagMatcher matcher = new TagMatcher(tags);
        Assertions.assertFalse(matcher.matches(recipe));

        Ingredient ingredient2 = new IngredientImpl(
                "cake",
                List.of(
                    tag1,
                    tag2
                )
        );
        Recipe recipe2 = new RecipeImpl(
                "cake",
                "",
                List.of(),
                List.of(
                        new QuantityRecipeItem(ingredient2, 0, false)
                )
        );

        Assertions.assertTrue(matcher.matches(recipe2));
    }
}
