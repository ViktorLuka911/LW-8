package Loggers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

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

        verify(newMockLoggerError, times(1)).sendError(title, message);
    }
}