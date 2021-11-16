package Storages;

import Entities.Implementations.AbstractEntity;
import Storages.Exceptions.NoSuchEntity;
import Storages.Implementations.AbstractStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class AbstractStorageTest {
    MockStorage storage;
    final UUID testID = UUID.randomUUID();
    final UUID testID2 = UUID.randomUUID();
    MockEntity entity1;
    MockEntity entity2;

    /**
     * A mock entity class.
     */
    static class MockEntity extends AbstractEntity {
        public MockEntity(UUID id) {
            super(id);
        }
    }

    /**
     * A mock storage for testing.
     */
    static class MockStorage extends AbstractStorage<MockEntity> {
        @Override
        public String type() {
            return "Storage";
        }
    }

    /**
     * Populate the storage so we can test it
     */
    @BeforeEach
    public void setUp() {
        this.storage = new MockStorage();
        this.entity1 = new MockEntity(testID);
        this.entity2 = new MockEntity(UUID.randomUUID());
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
        MockEntity entity3 = new MockEntity(idTest);
        this.storage.add(entity3);
        Assertions.assertTrue(this.storage.contains(idTest));
    }

    /**
     * Test the remove method of AbstractStorage
     */
    @Test
    public void testRemove() {
        UUID idTest = UUID.randomUUID();

        MockEntity entity4 = new MockEntity(idTest);

        this.storage.add(entity4);
        Assertions.assertTrue(this.storage.contains(idTest));

        // now testing the removal of entity 4
        this.storage.remove(entity4);
        Assertions.assertFalse(this.storage.contains(idTest));
    }
}
