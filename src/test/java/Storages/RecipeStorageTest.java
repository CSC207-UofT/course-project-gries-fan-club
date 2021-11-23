package Storages;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.RecipeImpl;
import Entities.Implementations.TagImpl;
import Entities.Implementations.VolumetricRecipeItem;
import Entities.RecipeItem;
import Entities.Tag;
import Storages.Implementations.RecipeStorageImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RecipeStorageTest {
    RecipeStorageImpl recipeStorage;
    RecipeImpl recipe1;
    RecipeImpl recipe2;
    TagImpl glutenTag;

    @BeforeEach
    public void setup() {
        this.recipeStorage = new RecipeStorageImpl();
        this.glutenTag = new TagImpl("Gluten");
        // Make ingredients
        IngredientImpl ingredient1 = new IngredientImpl(UUID.randomUUID(), "egg",
                Collections.singletonList(this.glutenTag));

        IngredientImpl ingredient2 = new IngredientImpl(UUID.randomUUID(), "flour",
                Collections.singletonList(new TagImpl("Vegan")));

        IngredientImpl ingredient3 = new IngredientImpl(UUID.randomUUID(), "oats",
                Collections.singletonList(new TagImpl("Vegan")));

        // Make recipe items
        VolumetricRecipeItem item1 = new VolumetricRecipeItem(ingredient1, 100, false);
        VolumetricRecipeItem item2 = new VolumetricRecipeItem(ingredient2, 100, false);
        VolumetricRecipeItem item3 = new VolumetricRecipeItem(ingredient3, 100, false);


        this.recipe1 = new RecipeImpl("recipe1", "description",
                Collections.singletonList("instructions"), Collections.singletonList(item1));

        List<RecipeItem> items = new ArrayList<>();
        items.add(item2);
        items.add(item3);

        this.recipe2 = new RecipeImpl("recipe2", "description",
                Collections.singletonList("instructions"), items);

        recipeStorage.add(this.recipe1);
        recipeStorage.add(this.recipe2);
    }

    /**
     * Tests the testFindByName method in RecipeStorageImpl
     */
    @Test
    public void testFindByName() {
        Assertions.assertTrue(this.recipeStorage.findByName("recipe1").contains(this.recipe1));
    }

    @Test
    public void testFindByTags() {
        Collection<Tag> tags = new ArrayList<>();
        tags.add(new TagImpl("Vegan"));

        Assertions.assertTrue(this.recipeStorage.findByTags(tags).contains(this.recipe2));
        Assertions.assertEquals(this.recipeStorage.findByTags(tags).size(), 1);
    }

    @Test
    public void testFindByOppositeTags() {
        Collection<Tag> tags = new ArrayList<>();
        tags.add(this.glutenTag);

        Assertions.assertTrue(this.recipeStorage.findByOppositeTags(tags).contains(this.recipe2));
        // makes sure recipe1 is not in the list because it contains gluten
        Assertions.assertFalse(this.recipeStorage.findByOppositeTags(tags).contains(this.recipe1));
    }


    @Test
    public void testRecipes() {
        // Check if all three ingredients are in the colleciton and that the collection only has a size of 3
        Assertions.assertTrue(this.recipeStorage.recipes().contains(this.recipe1));
        Assertions.assertTrue(this.recipeStorage.recipes().contains(this.recipe2));
        Assertions.assertEquals(this.recipeStorage.recipes().size(), 2);
    }



}
