package test.java.Entities;
import main.java.Entities.Tag;
import org.junit.Test;
import static org.junit.Assert.*;

public class TagTest {
    @Test
    public void testName() {
        Tag tag = new Tag("name");
        assertEquals("name", tag.name());
    }
}
