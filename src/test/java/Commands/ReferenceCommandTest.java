package Commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ReferenceCommandTest {
    private ReferenceCommand referenceCommand;

    @BeforeEach
    void setUp() {
        referenceCommand = new ReferenceCommand("Довідка");
    }

    @Test
    void testExecute() {
        // Підготовка для перенаправлення стандартного вводу
        InputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in); // Перенаправлення System.in на наш InputStream

        // Виклик методу execute
        referenceCommand.execute();

        // Додайте перевірки, щоб підтвердити, що метод працює правильно
        // Наприклад, перевірте, чи були виконані певні дії, якщо це можливо

        // Відновлення стандартного вводу
        System.setIn(System.in);
    }
}
