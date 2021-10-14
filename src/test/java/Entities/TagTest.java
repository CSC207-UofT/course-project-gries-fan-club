package test.java.Entities;
import main.java.Entities.TagImpl;
import org.junit.Test;
import static org.junit.Assert.*;

public class TagTest {
    @Test
    public void testName() {
        TagImpl tag = new TagImpl("name");
        assertEquals("name", tag.name());
    }
}
