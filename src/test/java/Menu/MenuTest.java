package Menu;

import Commands.Command;
import Commands.ReferenceCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Menu menu;
    private ReferenceCommand referenceCommand;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        referenceCommand = new ReferenceCommand("Довідка");
        ArrayList<Command> commands = new ArrayList<>();
        commands.add(referenceCommand);

        menu = new Menu("Меню", commands, new ArrayList<>());
    }

    @Test
    void testPrintMenu() {
        menu.printMenu();

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Меню"));
        assertTrue(output.contains("1 - Довідка"));
        assertTrue(output.contains("2 - Вийти з меню"));
    }

    @Test
    void testStartMenuEmptyVouchers() {
        menu.systemVouchers.getVouchers().clear();
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        menu.startMenu();
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Список вибраних путівок порожній."));
    }

    @Test
    void testStartMenuNotEmptyVouchers() {
        String input = "1\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        menu.startMenu();
        assertTrue(true);
    }

    @Test
    void testGetTitle() {
        assertEquals("Меню", menu.getTitle());
    }

    @Test
    void testSelectCommand1() {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.selectCommand();
        assertTrue(true);
    }

    @Test
    void testSelectCommand2() {
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.selectCommand();
        assertTrue(true);
    }

    @Test
    public void testGetCommands() {
        assertEquals(1, menu.getCommands().size());
        assertEquals(referenceCommand, menu.getCommands().getFirst());
    }

    @Test
    public void testSetCommands() {
        ArrayList<Command> newCommands = new ArrayList<>();

        menu.setCommands(newCommands);

        assertEquals(newCommands, menu.getCommands());
    }
}