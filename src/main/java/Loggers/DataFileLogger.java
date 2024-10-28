package Loggers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataFileLogger {
    public BufferedWriter writer = null;

    public void init(String filePath, boolean isFirst) {
        try {
            writer = (isFirst) ? new BufferedWriter(new FileWriter(filePath, true)) : new BufferedWriter(new FileWriter(filePath, false));
        } catch (IOException e) {
            System.err.println("\n\tНе вдалося відкрити файл для запису: " + e.getMessage());
        }
    }

    public void log(String message) {
        if (writer != null) {
            try {
                writer.write(message);
                writer.newLine();  // Додає символ нового рядка
                writer.flush();    // Примусовий запис на диск
            } catch (IOException e) {
                System.err.println("Помилка під час запису повідомлення: " + e.getMessage());
            }
        }
    }

    // Закрити потік виведення
     public void close() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Помилка під час закриття файлу: " + e.getMessage());
            }
            writer = null;
        }
    }
}