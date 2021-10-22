package test.java.Entities;
import main.java.Entities.AbstractEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class baseEntityTest {
    @Test
    public void assignIDTest() {
        class TestAbstract extends AbstractEntity {
            public TestAbstract(String id) {
                super(id);
            }

            public TestAbstract() {
                super();
            }

            @Override
            public String id() {
                return super.id();
            }
        }
    }

}
