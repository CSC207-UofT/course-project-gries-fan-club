package Entities.Implementations;

import Entities.RecipeItem;
import Entities.Ingredient;
import Entities.Tag;
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
        QuantityRecipeItem item1 = new QuantityRecipeItem(ingredient1, 15f, false);

        Ingredient ingredient2 = new IngredientImpl("cucumber", Collections.emptyList());
        QuantityRecipeItem item2 = new QuantityRecipeItem(ingredient2, 1f, false);


        List<RecipeItem> recipeItems = new ArrayList<>();
        recipeItems.add((RecipeItem) item1);
        recipeItems.add((RecipeItem) item2);

        RecipeImpl recipe = new RecipeImpl("name", "description", Collections.singletonList("instructions"), recipeItems);

        Assertions.assertEquals(recipeItems, recipe.items());
        Assertions.assertEquals(recipeItems.size(), recipe.items().size());
    }
    @Test
    public void testRecipetags() {

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

        VolumetricRecipeItem item1 = new VolumetricRecipeItem(ingredient1, 250f, false);
        QuantityRecipeItem item2 = new QuantityRecipeItem(ingredient2, 2f, false);
        VolumetricRecipeItem item3 = new VolumetricRecipeItem(ingredient3, 100f, false);
        QuantityRecipeItem item4 = new QuantityRecipeItem(ingredient4, 55f, false);
        VolumetricRecipeItem item5 = new VolumetricRecipeItem(ingredient5, 125f, false);
        VolumetricRecipeItem item6 = new VolumetricRecipeItem(ingredient6, 5f, false);

        List<RecipeItem> recipeItems1 = new ArrayList<>();
        recipeItems1.add((VolumetricRecipeItem) item1);
        recipeItems1.add((QuantityRecipeItem) item2);
        recipeItems1.add((VolumetricRecipeItem) item3);
        recipeItems1.add((QuantityRecipeItem) item4);
        recipeItems1.add((VolumetricRecipeItem) item5);
        recipeItems1.add((VolumetricRecipeItem) item6);

        RecipeImpl recipe = new RecipeImpl("Cookies", "Yummy chocolate chip cookies, best in the world.", Collections.singletonList("instructions"), recipeItems1);

        HashSet<Tag> tags = new HashSet<>();
        tags.add(tag1);
        tags.add(tag3);
        tags.add(tag2);

        Assertions.assertEquals(recipe.recipetags(), tags);
    }


}
