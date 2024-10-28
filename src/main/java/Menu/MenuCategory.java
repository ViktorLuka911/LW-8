package Menu;

import Commands.Command;
import Commands.ShowListCommand;
import Utilities.Utilities;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuCategory extends Menu {
    public MenuCategory() {

        // Ініціалізація списку підменю
        ArrayList<Menu> subMenus = new ArrayList<>();

        // Ініціалізація списку команд
        ArrayList<Command> commands = new ArrayList<>(
                Arrays.asList(
                        new ShowListCommand("Вивести всі путівки"),
                        new ShowListCommand("За країною"),
                        new ShowListCommand("За типом"),
                        new ShowListCommand("За транспортом"),
                        new ShowListCommand("За харчуванням"),
                        new ShowListCommand("За бюджетом")
                )
        );

        super("Меню для вибору категорії виведення", commands, subMenus);
    }

    @Override
    public void printMenu() {
        System.out.println("\n\t\t\t" + title  + "\n");
        int i = 0;
        while (i < commands.size()) {
            System.out.println("\t " + (i + 1) + " - " + commands.get(i).getTitle());
            i++;
        }
    }

    @Override
    public boolean selectCommand() {
        int choice = Utilities.getValidatedInput(1, 7);
        boolean isRunning = true;
        switch (choice) {
            case 1 -> commands.get(0).execute();
            case 2 -> commands.get(1).execute();
            case 3 -> commands.get(2).execute();
            case 4 -> commands.get(3).execute();
            case 5 -> commands.get(4).execute();
            case 6 -> commands.get(5).execute();
            case 7 -> isRunning = false;
        }

        return false;
    }

}
