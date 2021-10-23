package Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class AbstractEntityTest {

    /**
     * Class that helps us test the abstract class AbstractEntity
     */
    class EntityTester extends AbstractEntity {
        public EntityTester(UUID id) {
            super(id);
        }

        public EntityTester() {
            super();
        }

        @Override
        public UUID id() {
            return super.id();
        }
    }

    /**
     * Tests both the first constructor that accepts and ID and also the id() method
     * to ensure that an id passed in is correctly used
     */
    @Test
    public void EntityTesterConstructorTest() {
        UUID randomID = UUID.randomUUID();
        EntityTester obj = new EntityTester(randomID);
        Assertions.assertEquals(randomID, obj.id());
    }
}
