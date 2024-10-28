package Menu;

import Utilities.Utilities;
import Commands.Command;
import Commands.ShowListCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MenuSortOrderTest {

    private MenuSortOrder MenuSortOrder;

    @BeforeEach
    public void setUp() {
        MenuSortOrder = new MenuSortOrder("Параметер сортування");
    }

    @Test
    public void testPrintMenu() {
        MenuSortOrder.printMenu();
        assertTrue(true);
    }

    @Test
    public void testSelectCommand1() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 2)).thenReturn(1);

            Command mockCommand = mock(ShowListCommand.class);
            MenuSortOrder.commands.set(0, mockCommand);

            MenuSortOrder.selectCommand();

            verify(mockCommand, times(1)).execute();
            mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 2));
        }
    }

    @Test
    public void testSelectCommand2() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 2)).thenReturn(2);

            Command mockCommand = mock(ShowListCommand.class);
            doNothing().when(mockCommand).execute();

            MenuSortOrder.commands.set(1, mockCommand);

            MenuSortOrder.selectCommand();

            verify(mockCommand, times(1)).execute();
            mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 2));
        }
    }
}