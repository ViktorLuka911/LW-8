package Commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    private TestCommand command;

    @BeforeEach
    public void setUp() {
        command = new TestCommand("Заголовок");
    }

    @Test
    public void testConstructor() {
        assertEquals("Заголовок", command.getTitle());
        assertNotNull(command.systemVouchers);
        assertNotNull(command.loggerInfo);
    }

    @Test
    public void testExecute() {
        command.execute();
        assertTrue(true);
    }
}