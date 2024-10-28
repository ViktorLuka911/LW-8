package Menu;

import Utilities.Utilities;
import Commands.Command;
import Commands.ShowListCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MenuSortTest {

    private MenuSort menuSort;

    @BeforeEach
    public void setUp() {
        menuSort = new MenuSort();
    }

    @Test
    public void testPrintMenu() {
        menuSort.printMenu();
        assertTrue(true);
    }

    @Test
    public void testSelectCommand1() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 3)).thenReturn(1);

            Command mockCommand = mock(ShowListCommand.class);
            menuSort.commands.set(0, mockCommand);

            menuSort.selectCommand();

            verify(mockCommand, times(1)).execute();
            mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 3));
        }
    }

    @Test
    public void testSelectCommand2() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 3)).thenReturn(2);

            Command mockCommand = mock(ShowListCommand.class);
            doNothing().when(mockCommand).execute();

            menuSort.commands.set(1, mockCommand);

            menuSort.selectCommand();

            verify(mockCommand, times(1)).execute();
            mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 3));
        }
    }

    @Test
    public void testSelectCommand3() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 3)).thenReturn(3);

            Command mockCommand = mock(ShowListCommand.class);
            menuSort.commands.set(2, mockCommand);

            menuSort.selectCommand();

            verify(mockCommand, times(1)).execute();
            mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 3));
        }
    }
}