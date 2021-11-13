package Commands;

import Commands.Implementations.CommandImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CommandTest {
    /**
     * This tests the constructor, all the add methods and the .data() method.
     */
    @Test
    public void testConstructor() {
        Map<String, String> testData = new HashMap<String, String>();
        testData.put("Tags", "Gluten, Vegan, Dairy");

        CommandImpl command = new CommandImpl("Tags Gluten, Vegan, Dairy");
        Assertions.assertEquals(command.data(), testData);
    }
}
