package Entities.Implementations;

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

    @Test
    public void testEquals() {
        UUID randomID = UUID.randomUUID();
        UUID secondID = UUID.randomUUID();
        EntityTester obj = new EntityTester(randomID);
        EntityTester obj2 = new EntityTester(randomID);
        EntityTester obj3 = new EntityTester(secondID);

        Assertions.assertNotEquals(null, obj);
        Assertions.assertEquals(obj, obj);
        Assertions.assertEquals(obj2, obj);
        Assertions.assertNotEquals(obj3, obj);
    }
}
