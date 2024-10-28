package Loggers;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

class LoggerInfoTest {

    @Mock
    private Logger mockLogger;

    @Mock
    private LoggerError mockLoggerError;

    private LoggerInfo loggerInfo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        loggerInfo = LoggerInfo.getInstance();

        loggerInfo.setFileLogger(mockLogger);
        loggerInfo.setErrorLogger(mockLoggerError);
    }

//    @Test
//    void testIOExceptionInConstructor() throws IOException {
//        when(new FileHandler("logs/program.log", true)).thenThrow(new IOException("Файл не доступний"));
//
//        LoggerInfo loggerInfo = spy(LoggerInfo.getInstance());
//        loggerInfo.setErrorLogger(mockLoggerError);
//
//        verify(mockLoggerError, times(1)).sendError(eq("Помилка відкриття файлу"), anyString());
//    }

    @Test
    void testLogInfo() {
        String message = "Test info message";

        loggerInfo.logInfo(message);

        verify(mockLogger, times(1)).info(message);
    }

    @Test
    void testLogError() {
        String title = "Error title";
        String message = "Error message";

        loggerInfo.logError(title, message);

        verify(mockLogger, times(1)).severe(title + message);

        verify(mockLoggerError, times(1)).sendError(title, message);
    }

    @Test
    void testSetFileLogger() {
        Logger newMockLogger = mock(Logger.class);

        loggerInfo.setFileLogger(newMockLogger);

        String message = "Тестовий логгер";
        loggerInfo.logInfo(message);

        verify(newMockLogger, times(1)).info(message);
    }

    @Test
    void testSetErrorLogger() {
        LoggerError newMockLoggerError = mock(LoggerError.class);

        loggerInfo.setErrorLogger(newMockLoggerError);

        String title = "Заголовок помилки";
        String message = "Текст помилки";
        loggerInfo.logError(title, message);

        // Перевіряємо, що новий errorLogger був викликаний
        verify(newMockLoggerError, times(1)).sendError(title, message);
    }
}