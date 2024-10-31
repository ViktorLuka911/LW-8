package Utilities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

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
    public void testOutOfRangeInput() {
        String input = "15\n13\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Utilities.getValidatedInput(1, 14);
        assertEquals(13, result);
    }

    @Test
    public void testValidDateInput() {
        String input = String.format("%s%n", LocalDate.now().plusDays(1));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Utilities.getValidatedDateInput();
        assertEquals(input.trim(), result);
    }

    @Test
    public void testInvalidDateInput() throws IOException {
        String input = String.format("Неправильна дата%n%s%n", LocalDate.now().plusDays(1));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Utilities.getValidatedDateInput();
        assertEquals(LocalDate.now().plusDays(1).toString(), result);

        Path path = Paths.get("logs/program.log");

        List<String> lines = Files.readAllLines(path);
        lines = lines.subList(0, lines.size() - 5);
        Files.write(path, lines);
    }

    @Test
    public void testDateInputPastDate() {
        String input = String.format("%s%n%s%n", LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
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