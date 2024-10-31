package Commands;

import Menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class GoToMenuTest {

    private GoToMenuCommand command;
    private Menu mockMenu;

    @BeforeEach
    void setUp() {
        mockMenu = Mockito.mock(Menu.class);

        command = new GoToMenuCommand("Перейти до меню", mockMenu);
    }

    @Test
    void testExecute() {
        command.execute();

        verify(mockMenu).startMenu();
    }
}
