package Menu;

import Utilities.Utilities;
import Commands.Command;
import Commands.ShowListCommand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MenuSortTest {

    private MenuSort menu;
    private MockedStatic<Utilities> mockedUtilities;

    @BeforeEach
    public void setUp() {
        menu = new MenuSort();
        mockedUtilities = mockStatic(Utilities.class);
    }

    @AfterEach
    public void tearDown() {
        if (mockedUtilities != null) {
            mockedUtilities.close();
        }
    }

    @Test
    public void testPrintMenu() {
        menu.printMenu();
        assertTrue(true);
    }

    @Test
    public void testSelectCommand1() {
        mockedUtilities.when(() -> Utilities.getValidatedInput(1, 3)).thenReturn(1);

        Command mockCommand = mock(ShowListCommand.class);
        menu.commands.set(0, mockCommand);

        menu.selectCommand();

        verify(mockCommand, times(1)).execute();
        mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 3));
    }

    @Test
    public void testSelectCommand2() {
        mockedUtilities.when(() -> Utilities.getValidatedInput(1, 3)).thenReturn(2);

        Command mockCommand = mock(ShowListCommand.class);
        doNothing().when(mockCommand).execute();

        menu.commands.set(1, mockCommand);

        menu.selectCommand();

        verify(mockCommand, times(1)).execute();
        mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 3));
    }

    @Test
    public void testSelectCommand3() {
        mockedUtilities.when(() -> Utilities.getValidatedInput(1, 3)).thenReturn(3);

        Command mockCommand = mock(ShowListCommand.class);
        menu.commands.set(2, mockCommand);

        menu.selectCommand();

        verify(mockCommand, times(1)).execute();
        mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 3));
    }
}