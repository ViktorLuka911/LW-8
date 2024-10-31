package Loggers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataFileLogger {
    public LoggerInfo logger;
    public BufferedWriter writer = null;

    public DataFileLogger() {
        logger = LoggerInfo.getInstance();
    }

    public void init(String filePath, boolean isFirst) {
        try {
            writer = (isFirst) ? new BufferedWriter(new FileWriter(filePath, true)) : new BufferedWriter(new FileWriter(filePath, false));
        } catch (IOException e) {
            logger.logError("\n\tНе вдалося відкрити файл для запису: %s%n", e.getMessage());
        }
    }

    public void log(String message) {
        if (writer != null) {
            try {
                writer.write(message);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                logger.logError("Помилка під час запису повідомлення: %s%n", e.getMessage());
            }
        }
    }

     public void close() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                logger.logError("Помилка під час закриття файлу: %s%n", e.getMessage());
            }
            writer = null;
        }
    }
}