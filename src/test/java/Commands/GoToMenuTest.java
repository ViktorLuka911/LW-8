package Commands;

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
        mockMenu = Mockito.mock(Menu.class);

        goToMenuCommand = new GoToMenuCommand("Перейти до меню", mockMenu);
    }

    @Test
    void testExecute() {
        goToMenuCommand.execute();

        verify(mockMenu).startMenu();
    }
}
