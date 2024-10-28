package Loggers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DataFileLoggerTest {
    private DataFileLogger logger;
    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        logger = new DataFileLogger();
        tempFile = File.createTempFile("testLog", ".txt");
    }

    @AfterEach
    void tearDown() {
        logger.close();
    }

    @Test
    void testInitWithAppendMode() throws IOException {
        logger.init(tempFile.getAbsolutePath(), true);
        assertNotNull(logger.writer);

        logger.log("Перший запис");
        logger.close();

        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        assertEquals("Перший запис", reader.readLine());
        reader.close();
    }

    @Test
    void testLog() throws IOException {
        logger.init(tempFile.getAbsolutePath(), false);
        logger.log("Тестовий текст");

        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        assertEquals("Тестовий текст", reader.readLine());
        reader.close();
    }

    @Test
    void testMultipleLogs() throws IOException {
        logger.init(tempFile.getAbsolutePath(), false);
        logger.log("Перше повідомлення");
        logger.log("Друге повідомлення");

        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        assertEquals("Перше повідомлення", reader.readLine());
        assertEquals("Друге повідомлення", reader.readLine());
        reader.close();
    }

    @Test
    void testClose() {
        logger.init(tempFile.getAbsolutePath(), false);
        logger.close();
        assertNull(logger.writer);
    }

    @Test
    void testAppendMode() throws IOException {
        logger.init(tempFile.getAbsolutePath(), false);
        logger.log("Оригінальний запис");
        logger.close();

        logger.init(tempFile.getAbsolutePath(), true);
        logger.log("Новий запис");
        logger.close();

        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        assertEquals("Оригінальний запис", reader.readLine());
        assertEquals("Новий запис", reader.readLine());
        reader.close();
    }
}