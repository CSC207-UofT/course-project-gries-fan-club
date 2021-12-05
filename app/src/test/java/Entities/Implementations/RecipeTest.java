package Entities.Implementations;

import Entities.Ingredient;
import Entities.RecipeItem;
import Entities.RecipeItemDisplay;
import Entities.Tag;
import RecipeItemDisplayers.Quantifiable;
import RecipeItemDisplayers.Volumetric;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class RecipeTest {
    RecipeImpl recipe;

    @BeforeEach
    public  void setup() {
        this.recipe = new RecipeImpl("name", "description", Collections.singletonList("instructions"), Collections.emptyList());
    }

    @Test
    public void testName() {
        Assertions.assertEquals("name", recipe.name());
    }

    @Test
    public void testDescription() {
        Assertions.assertEquals("description", recipe.description());
    }

    @Test
    public void testInstructions() {
        Assertions.assertEquals("instructions", recipe.instructions().get(0));
    }

    @Test
    public void testItems() {
        Ingredient ingredient1 = new IngredientImpl("apple", Collections.emptyList());
        RecipeItemDisplay quantifiable = new Quantifiable();
        RecipeItem item1 = new RecipeItemImpl(ingredient1, 15f, false, quantifiable);

        Ingredient ingredient2 = new IngredientImpl("cucumber", Collections.emptyList());
        RecipeItem item2 = new RecipeItemImpl(ingredient2, 1f, false, quantifiable);


        List<RecipeItem> recipeItems = List.of(
                item1,
                item2
        );

        RecipeImpl recipe = new RecipeImpl("name", "description", Collections.singletonList("instructions"), recipeItems);

        Assertions.assertEquals(recipeItems, recipe.items());
        Assertions.assertEquals(recipeItems.size(), recipe.items().size());
    }

    @Test
    public void testTags() {
        RecipeItemDisplay quantifiable = new Quantifiable();
        RecipeItemDisplay volumetric = new Volumetric();


        TagImpl tag1 = new TagImpl("Gluten");
        TagImpl tag2 = new TagImpl("Dairy");
        TagImpl tag3 = new TagImpl("Non-Vegan");

        List<Tag> list1 = new ArrayList<>();
        list1.add(tag1);

        List<Tag> list2 = new ArrayList<>();
        list2.add(tag3);

        List<Tag> list3 = new ArrayList<>();
        list3.add(tag3);
        list3.add(tag2);

        IngredientImpl ingredient1 = new IngredientImpl("flour",list1);
        IngredientImpl ingredient2 = new IngredientImpl("egg", list2);
        IngredientImpl ingredient3 = new IngredientImpl("oil", Collections.emptyList());
        IngredientImpl ingredient4 = new IngredientImpl("chocolate chips", list3);
        IngredientImpl ingredient5 = new IngredientImpl("water", Collections.emptyList());
        IngredientImpl ingredient6 = new IngredientImpl("baking soda", Collections.emptyList());

        RecipeItem item1 = new RecipeItemImpl(ingredient1, 250f, false, volumetric);
        RecipeItem item2 = new RecipeItemImpl(ingredient2, 2f, false, quantifiable);
        RecipeItem item3 = new RecipeItemImpl(ingredient3, 100f, false, volumetric);
        RecipeItem item4 = new RecipeItemImpl(ingredient4, 55f, false, quantifiable);
        RecipeItem item5 = new RecipeItemImpl(ingredient5, 125f, false, volumetric);
        RecipeItem item6 = new RecipeItemImpl(ingredient6, 5f, false, volumetric);

        List<RecipeItem> recipeItems1 = new ArrayList<>();
        recipeItems1.add(item1);
        recipeItems1.add(item2);
        recipeItems1.add(item3);
        recipeItems1.add(item4);
        recipeItems1.add(item5);
        recipeItems1.add(item6);

        RecipeImpl recipe = new RecipeImpl("Cookies", "Yummy chocolate chip cookies, best in the world.", Collections.singletonList("instructions"), recipeItems1);

        HashSet<Tag> tags = new HashSet<>();
        tags.add(tag1);
        tags.add(tag3);
        tags.add(tag2);

        Assertions.assertEquals(recipe.tags(), tags);
    }


}
