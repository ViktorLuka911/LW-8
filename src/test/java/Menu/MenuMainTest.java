package Menu;

import Utilities.Utilities;
import Commands.Command;
import Commands.ShowListCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MenuMainTest {

    private MenuMain menuMain;

    @BeforeEach
    public void setUp() {
        menuMain = new MenuMain();
    }

    @Test
    public void testSelectCommand1() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 7)).thenReturn(1);

            Command mockCommand = mock(ShowListCommand.class);
            menuMain.commands.set(0, mockCommand);

            menuMain.selectCommand();

            verify(mockCommand, times(1)).execute();
            mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 7)); // Перевірка виклику
        }
    }

    @Test
    public void testSelectCommand2() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 7)).thenReturn(2);

            Command mockCommand = mock(ShowListCommand.class);
            doNothing().when(mockCommand).execute();

            menuMain.commands.set(1, mockCommand);

            menuMain.selectCommand();

            verify(mockCommand, times(1)).execute();
            mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 7)); // Перевірка виклику
        }
    }

    @Test
    public void testSelectCommand3() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 7)).thenReturn(3);

            Command mockCommand = mock(ShowListCommand.class);
            menuMain.commands.set(2, mockCommand);

            menuMain.selectCommand();

            verify(mockCommand, times(1)).execute();
            mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 7)); // Перевірка виклику
        }
    }

    @Test
    public void testSelectCommand4() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 7)).thenReturn(4);

            Command mockCommand = mock(ShowListCommand.class);
            menuMain.commands.set(3, mockCommand);

            menuMain.selectCommand();

            verify(mockCommand, times(1)).execute();
            mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 7)); // Перевірка виклику
        }
    }

    @Test
    public void testSelectCommand5() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 7)).thenReturn(5);

            Command mockCommand = mock(ShowListCommand.class);
            menuMain.commands.set(4, mockCommand);

            menuMain.selectCommand();

            verify(mockCommand, times(1)).execute();
            mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 7)); // Перевірка виклику
        }
    }

    @Test
    public void testSelectCommand6() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 7)).thenReturn(6);

            Command mockCommand = mock(ShowListCommand.class);
            menuMain.commands.set(5, mockCommand);

            menuMain.selectCommand();

            verify(mockCommand, times(1)).execute();
            mockedUtilities.verify(() -> Utilities.getValidatedInput(1, 7)); // Перевірка виклику
        }
    }


    @Test
    public void testSelectCommand_Exit() {
        try (var mockedUtilities = mockStatic(Utilities.class)) {
            mockedUtilities.when(() -> Utilities.getValidatedInput(1, 7)).thenReturn(7);

            menuMain.selectCommand();

            boolean isRunning = menuMain.selectCommand();
            assertFalse(isRunning);
        }
    }
}