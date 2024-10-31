package Commands;

import java.util.Scanner;

public class ReferenceCommand extends Command {

    public ReferenceCommand(String title) {
        super(title);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nФункціонал програми:\n");
        System.out.println("1. Додати путівку      - Введіти дані про нову путівку.");
        System.out.println("2. Фільтрувати путівки - Виберіть критерії для відбору: країна, тип, транспорт, харчування, бюджет.");
        System.out.println("3. Сортувати путівки   - Можна сортувати за: назвою, кількістю днів, ціною, датою.");
        System.out.println("4. Видалити путівку    - Вибрати путівку для видалення.");
        System.out.println("5. Показати путівки    - Виведення списку путівок.");

        System.out.println("\n\nСтруктура функціоналу програми:");

        System.out.println("\t------------------------------------------           --------------------------------------------");
        System.out.println("\t|              Головне меню              |    |----→ | Послідовність введення даних про путівку |");
        System.out.println("\t------------------------------------------    |      --------------------------------------------");
        System.out.println("\t| * Довідка                              |    |      | * Вибрати країну                         |");
        System.out.println("\t| * Перейти до путівок                   |    |      | * Вибрати тип путівки                    |");
        System.out.println("\t------------------------------------------    |      | * Вибрати транспорт                      |");
        System.out.println("\t                     |                        |      | * Вибрати харчування                     |");
        System.out.println("\t                     |                        |      | * Вибрати тип бюджету                    |");
        System.out.println("\t                     |                        |      | * Ввести кількість днів                  |");
        System.out.println("\t                     |                        |      | * Ввести дату путівки                    |");
        System.out.println("\t                     |                        |      --------------------------------------------");
        System.out.println("\t                     ↓                        |");
        System.out.println("\t------------------------------------------    |");
        System.out.println("\t|           Меню вибраних путівок        |    |");
        System.out.println("\t------------------------------------------    |");
        System.out.println("\t| * Вивести поточний список              | ---|");
        System.out.println("\t| * Додати нову путівку                  |");
        System.out.println("\t| * Посортувати путівки за параметрами   |          ------------------------------------------");
        System.out.println("\t| * Вивести путівки за категорією        |  ------→ |  Меню перегляду путівок за категорією  |");
        System.out.println("\t| * Видалити путівку                     |          ------------------------------------------");
        System.out.println("\t------------------------------------------          | * Весь список путівок                  |");
        System.out.println("\t                   |                                | * Переглянути путівки за країною       |");
        System.out.println("\t                   |                                | * Переглянути путівки за типом         |");
        System.out.println("\t                   |                                | * Переглянути путівки за транспортом   |");
        System.out.println("\t                   ↓                                | * Переглянути путівки за харчуванням   |");
        System.out.println("\t------------------------------------------          | * Переглянути путівки за бюджетом      |");
        System.out.println("\t| Меню сортування путівок за параметрами |          ------------------------------------------");
        System.out.println("\t------------------------------------------");
        System.out.println("\t| * Сортувати путівки за кількістю днів  |");
        System.out.println("\t| * Сортувати путівки за ціною           |");
        System.out.println("\t| * Сортувати путівки за датою           |");
        System.out.println("\t------------------------------------------");
        System.out.println("\t                   |                      ");
        System.out.println("\t                   ↓                      ");
        System.out.println("\t------------------------------------------");
        System.out.println("\t|    Порядок сортування за параметром    |");
        System.out.println("\t------------------------------------------");
        System.out.println("\t| * За зростанням                        |");
        System.out.println("\t| * За спаданням                         |");
        System.out.println("\t------------------------------------------\n");

        System.out.print("\n\tНатисніть Enter, щоб продовжити...");
        scanner.nextLine();
    }
}