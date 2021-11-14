package Storages;

import Entities.Implementations.TagImpl;
import Storages.Implementations.TagStorageImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TagStorageTest {

    TagStorageImpl tagStorage;
    TagImpl tag1;

    @BeforeEach
    public void setup() {
        this.tagStorage = new TagStorageImpl();
        this.tag1 = new TagImpl("Vegan");
        this.tagStorage.add(this.tag1);
    }

    @Test
    public void testFindByName() {
        Assertions.assertTrue(this.tagStorage.findByName("Vegan").contains(this.tag1));
        Assertions.assertEquals(this.tagStorage.findByName("Vegan").size(), 1);
    }
}
