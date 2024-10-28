package Loggers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.LogRecord;
import java.util.logging.Level;

public class CustomFormatterTest {

    @Test
    public void testFormatInfoLog() {
        CustomFormatter formatter = new CustomFormatter();

        LogRecord record = new LogRecord(Level.INFO, "Текст");
        String formattedMessage = formatter.format(record);

        String expectedMessage = String.format("%s %n[INFO]: Текст%n%n",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(record.getMillis())));

        assertEquals(expectedMessage, formattedMessage);
    }

    @Test
    public void testFormatErrorLog() {
        CustomFormatter formatter = new CustomFormatter();

        LogRecord record = new LogRecord(Level.SEVERE, "Помилка");
        String formattedMessage = formatter.format(record);

        String expectedMessage = String.format("%s %n[ERROR]: Помилка%n%n",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(record.getMillis())));

        assertEquals(expectedMessage, formattedMessage);
    }

    @Test
    public void testDateTimeFormat() {
        CustomFormatter formatter = new CustomFormatter();

        LogRecord record = new LogRecord(Level.WARNING, "УВАГА");
        String formattedMessage = formatter.format(record);

        String expectedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(record.getMillis()));

        assertTrue(formattedMessage.contains(expectedDate));
    }
}
