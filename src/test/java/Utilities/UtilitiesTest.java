package Utilities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

public class UtilitiesTest {

    @Test
    public void testValidInput() {
        String input = "13\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Utilities.getValidatedInput(1, 14);
        assertEquals(13, result);
    }

    @Test
    public void testInvalidInput() {
        String input = "Не число\n13\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Utilities.getValidatedInput(1, 14);
        assertEquals(13, result);
    }

    @Test
    public void testInputOutOfRange() {
        String input = "15\n13\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Utilities.getValidatedInput(1, 14);
        assertEquals(13, result);
    }

    @Test
    public void testValidDateInput() {
        String input = LocalDate.now().plusDays(1).toString() + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Utilities.getValidatedDateInput();
        assertEquals(input.trim(), result);
    }

    @Test
    public void testInvalidDateInput() {
        String input = "Неправильна дата\n" + LocalDate.now().plusDays(1).toString() + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Utilities.getValidatedDateInput();
        assertEquals(LocalDate.now().plusDays(1).toString(), result);
    }

    @Test
    public void testDateInputPastDate() { // Неправильне введення - дата в минулому
        String input = LocalDate.now().minusDays(1).toString() + "\n" + LocalDate.now().plusDays(1).toString() + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Utilities.getValidatedDateInput();
        assertEquals(LocalDate.now().plusDays(1).toString(), result);
    }

    @Test
    public void testClearConsole() {
        Utilities.clearConsole();
        assertTrue(true);
    }
}