package Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TagTest {
    @Test
    public void testName() {
        TagImpl tag = new TagImpl("name");
        Assertions.assertEquals("name", tag.name());
    }
}
