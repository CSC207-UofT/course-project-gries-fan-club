package Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class AbstractEntityTest {

    /**
     * Class that helps us test the abstract class AbstractEntity.
     */
    static class EntityTester extends AbstractEntity {
        public EntityTester(UUID id) {
            super(id);
        }
    }

    /**
     * Ensure the assigned ID is returned from '.id'.
     */
    @Test
    public void testID() {
        UUID randomID = UUID.randomUUID();
        EntityTester obj = new EntityTester(randomID);
        Assertions.assertEquals(randomID, obj.id());
    }
}
