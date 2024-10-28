package Commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ReferenceCommandTest {
    private ReferenceCommand referenceCommand;

    @BeforeEach
    void setUp() {
        referenceCommand = new ReferenceCommand("Довідка");
    }

    @Test
    void testExecute() {
        InputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);

        referenceCommand.execute();

        System.setIn(System.in);
    }
}
