package Storages;
import Entities.Builders.IngredientBuilder;
import Entities.Builders.IngredientBuilderTest;
import Entities.Entity;
import Entities.Implementations.AbstractEntity;
import Entities.Implementations.IngredientImpl;
import Entities.Ingredient;
import Entities.Tag;
import Storages.Exceptions.NoSuchEntity;
import Storages.Implementations.AbstractStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.UUID;

public class AbstractStorageTest {
    AbstractStorage storage;
    UUID testID = UUID.randomUUID();
    UUID testID2 = UUID.randomUUID();
    AbstractEntity entity1;

    /**
     * A mock storage for testing.
     */
    static class MockStorage extends AbstractStorage<Ingredient> {
        @Override
        public String type() {
            return "Storage";
        }
    }
    static class MockEntity extends AbstractEntity {
        public MockEntity(UUID id) {
            super(id);
        }
    }


    /**
     * Populate the storage so we can test it
     */
    @BeforeEach
    public void setUp() {
        this.storage = new MockStorage();
        this.entity1 = new MockEntity(testID);
        AbstractEntity entity2 = new MockEntity(UUID.randomUUID());
        this.storage.add(entity1);
        this.storage.add(entity2);
    }

    /**
     * Test the contains method of the abstract storage
     */
    @Test
    public void testContains() {
        Assertions.assertTrue(this.storage.contains(this.testID));
        Assertions.assertFalse(this.storage.contains(this.testID2));
    }

    @Test
    public void testFind() throws NoSuchEntity {
        Assertions.assertEquals(this.storage.find(this.testID), this.entity1);
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(this.storage.size(), 2);
    }

    @Test
    public void testAdd() {
        UUID idTest = UUID.randomUUID();
        AbstractStorage testStorage = this.storage;
        AbstractEntity entity3 = new MockEntity(idTest);
        testStorage.add(entity3);
        Assertions.assertTrue(this.storage.contains(idTest));
    }

    @Test
    public void testRemove() {
        UUID idTest = UUID.randomUUID();
        AbstractStorage testStorage = this.storage;
        AbstractEntity entity4 = new MockEntity(idTest);
        testStorage.add(entity4);
        Assertions.assertTrue(this.storage.contains(idTest));
        // now testing the removal of entity 4
        testStorage.remove(entity4);
        Assertions.assertFalse(this.storage.contains(idTest));
    }
}
