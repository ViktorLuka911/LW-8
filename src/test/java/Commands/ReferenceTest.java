package Commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ReferenceTest {
    private ReferenceCommand command;

    @BeforeEach
    void setUp() {
        command = new ReferenceCommand("Довідка");
    }

    @Test
    void testExecute() {
        InputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);

        command.execute();

        System.setIn(System.in);
    }
}
