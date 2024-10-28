package Utilities;

import Loggers.LoggerInfo;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Utilities {

    private static final LoggerInfo loggerInfo = LoggerInfo.getInstance();

    //Функція для правильного введення
    public static int getValidatedInput(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.print("\n\n\tВаш вибір: ");
            while (!scanner.hasNextInt()) {
                System.out.println("\n\tНевірний ввід! Введіть число.");
                scanner.next();
                System.out.print("\n\n\tВаш вибір: ");
            }
            input = scanner.nextInt();
        } while (input < min || input > max);
        return input;
    }

    public static String getValidatedDateInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                // Спроба парсингу дати
                LocalDate parsedDate = LocalDate.parse(input);

                // Додаткова перевірка дати, якщо потрібно
                if (parsedDate.isBefore(LocalDate.now())) {
                    System.out.print("\n\tДата не може бути у минулому. Спробуйте знову (формат: YYYY-MM-DD):");
                    continue;
                }

                return input; // Повертаємо валідний рядок дати
            } catch (DateTimeParseException e) {
                System.out.print("\n\tНевірний формат дати. Спробуйте знову (формат: YYYY-MM-DD):");
                loggerInfo.logError("Виникла помилка під час встановлення дати путівки.\n", "Користувач ввів: " + input + ".");
            }
        }
    }

    // Функція для очищення консолі
    public static void clearConsole() {
        for (int clear = 0; clear < 10; clear++) {
            System.out.println("\n") ;
        }
    }

}