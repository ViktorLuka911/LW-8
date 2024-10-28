package Commands;

import Commands.GoToMenuCommand;
import Menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class GoToMenuTest {

    private GoToMenuCommand goToMenuCommand;
    private Menu mockMenu;

    @BeforeEach
    void setUp() {
        // Створюємо mock для Menu
        mockMenu = Mockito.mock(Menu.class);

        // Створюємо команду GoToMenuCommand
        goToMenuCommand = new GoToMenuCommand("Перейти до меню", mockMenu);
    }

    @Test
    void testExecute() {
        // Викликаємо метод execute
        goToMenuCommand.execute();

        verify(mockMenu).startMenu();
    }
}
