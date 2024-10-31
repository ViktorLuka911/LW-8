package Commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    private Command command;

    @BeforeEach
    public void setUp() {
        command = new Command("Заголовок");
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

    @Test void testSetTitle() {
        command.setTitle("Новий заголовок");
        assertEquals("Новий заголовок", command.getTitle());
    }
}