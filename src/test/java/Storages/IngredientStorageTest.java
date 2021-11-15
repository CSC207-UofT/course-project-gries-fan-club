package Storages;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.TagImpl;
import Entities.Tag;
import Storages.Implementations.IngredientStorageImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class IngredientStorageTest {
    IngredientStorageImpl ingredientStorage;
    IngredientImpl ingredient1;
    IngredientImpl ingredient2;
    IngredientImpl ingredient3;


    @BeforeEach
    public void setup() {
        this.ingredientStorage = new IngredientStorageImpl();
        this.ingredient1 = new IngredientImpl(UUID.randomUUID(), "ingredient1",
                Collections.singletonList(new TagImpl("Gluten")));
        this.ingredient2 = new IngredientImpl(UUID.randomUUID(), "ingredient12",
                Collections.singletonList(new TagImpl("Vegan")));
        this.ingredient3 = new IngredientImpl(UUID.randomUUID(), "ingredient4",
                Collections.singletonList(new TagImpl("Vegan")));
        this.ingredientStorage.add(ingredient1);
        this.ingredientStorage.add(ingredient2);
        this.ingredientStorage.add(ingredient3);
    }

    /**
     * Tests the testFindByName method in IngredientStorage
     */
    @Test
    public void testFindByName() {
        Assertions.assertTrue(this.ingredientStorage.findByName("ingredient1").contains(this.ingredient1));
        Assertions.assertTrue(this.ingredientStorage.findByName("ingredient1").contains(this.ingredient2));
    }

    /**
     * Tests the testFindByName method in IngredientStorage
     */
    @Test
    public void testFindByTags() {
        // Create collection containing vegan tag
        Collection<Tag> tags = new ArrayList<>();
        tags.add(new TagImpl("Vegan"));

        Assertions.assertTrue(this.ingredientStorage.findByTags(tags).contains(this.ingredient2));
        Assertions.assertTrue(this.ingredientStorage.findByTags(tags).contains(this.ingredient3));
    }

    /**
     * Test the ingredients method to ensure the correct ingredients are being returned
     */
    @Test
    public void testIngredients() {
        // Check if all three ingredients are in the collection and that the collection only has a size of 3
        Assertions.assertTrue(this.ingredientStorage.ingredients().contains(this.ingredient1));
        Assertions.assertTrue(this.ingredientStorage.ingredients().contains(this.ingredient2));
        Assertions.assertTrue(this.ingredientStorage.ingredients().contains(this.ingredient3));
        Assertions.assertEquals(this.ingredientStorage.ingredients().size(), 3);
    }
    @Test
    public void testFindByNameExact() {
        IngredientImpl ingredient4 = new IngredientImpl(UUID.randomUUID(),"butter", Collections.singletonList(new TagImpl("Dairy")));
        IngredientImpl ingredient5 = new IngredientImpl(UUID.randomUUID(),"Cocobutter", Collections.singletonList(new TagImpl("Dairy")));
        this.ingredientStorage.add(ingredient4);
        this.ingredientStorage.add(ingredient5);
        Assertions.assertSame(this.ingredientStorage.findByNameExact("butter").iterator().next(), ingredient4);
    }
}
