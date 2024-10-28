package Loggers;

import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.FileHandler;

public class LoggerInfo {
    private static LoggerInfo instance;
    private Logger fileLogger = Logger.getLogger(LoggerInfo.class.getName());
    private LoggerError errorLogger = new LoggerError();

    private LoggerInfo() {
        try {
            Logger rootLogger = Logger.getLogger("");
            for (var handler : rootLogger.getHandlers()) {
                rootLogger.removeHandler(handler);
            }

            // Створення FileHandler для запису у файл
            FileHandler fileHandler = new FileHandler("logs/program.log", true);
            fileHandler.setFormatter(new CustomFormatter());
            fileLogger.addHandler(fileHandler);
            fileLogger.setUseParentHandlers(false);

        } catch (IOException e) {
            errorLogger.sendError("Помилка відкриття файлу", e.getMessage());
        }
    }

    public static LoggerInfo getInstance() {
        if (instance == null) {
            instance = new LoggerInfo();
        }
        return instance;
    }

    public static void setInstance(LoggerInfo loggerInfo) {
        instance = loggerInfo;
    }

    public void logInfo(String message) {
        fileLogger.info(message);
    }

    public void logError(String title,String message) {
        fileLogger.severe(title + message);
        errorLogger.sendError(title, message);
    }

    public void setFileLogger(Logger logger) {
        this.fileLogger = logger;
    }

    public void setErrorLogger(LoggerError loggerError) {
        this.errorLogger = loggerError;
    }
}