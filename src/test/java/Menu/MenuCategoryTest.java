package Menu;

import Utilities.Utilities;
import Commands.Command;
import Commands.ShowListCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MenuCategoryTest {

    private MenuCategory menuCategory;

    @BeforeEach
    public void setUp() {
        menuCategory = new MenuCategory();
    }

    @Test
    public void testPrintMenu() {
        menuCategory.printMenu();

        assertTrue(true);
    }

    @Test
    public void testSelectCommand1() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 6)).thenReturn(1);

            Command mockCommand = mock(ShowListCommand.class);
            menuCategory.commands.set(0, mockCommand);

            menuCategory.selectCommand();

            assertTrue(true);
        }
    }

    @Test
    public void testSelectCommand2() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 6)).thenReturn(2);

            Command mockCommand = mock(ShowListCommand.class);
            doNothing().when(mockCommand).execute();

            menuCategory.commands.set(1, mockCommand);

            menuCategory.selectCommand();

            assertTrue(true);
        }
    }

    @Test
    public void testSelectCommand3() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 6)).thenReturn(3);

            Command mockCommand = mock(ShowListCommand.class);
            menuCategory.commands.set(2, mockCommand);

            menuCategory.selectCommand();

            assertTrue(true);
        }
    }

    @Test
    public void testSelectCommand4() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 6)).thenReturn(4);

            Command mockCommand = mock(ShowListCommand.class);
            menuCategory.commands.set(3, mockCommand);

            menuCategory.selectCommand();

            assertTrue(true);
        }
    }

    @Test
    public void testSelectCommand5() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 6)).thenReturn(5);

            Command mockCommand = mock(ShowListCommand.class);
            menuCategory.commands.set(4, mockCommand);

            menuCategory.selectCommand();

            assertTrue(true);
        }
    }

    @Test
    public void testSelectCommand6() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 6)).thenReturn(6);

            Command mockCommand = mock(ShowListCommand.class);
            menuCategory.commands.set(5, mockCommand);

            menuCategory.selectCommand();

            assertTrue(true);
        }
    }
}