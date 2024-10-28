package Menu;

import Commands.Command;
import Commands.ShowListCommand;
import Utilities.Utilities;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuCategory extends Menu {

    public MenuCategory() {

        ArrayList<Menu> subMenus = new ArrayList<>();

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
        System.out.printf("\n\t\t\t%s%n%n", title);
        for (int i = 0; i < commands.size(); i++) {
            System.out.printf("\t %d - %s%n", i + 1, commands.get(i).getTitle());
        }
    }

    @Override
    public boolean selectCommand() {
        int choice = Utilities.getValidatedInput(1, 6);
        switch (choice) {
            case 1 -> commands.get(0).execute();
            case 2 -> commands.get(1).execute();
            case 3 -> commands.get(2).execute();
            case 4 -> commands.get(3).execute();
            case 5 -> commands.get(4).execute();
            case 6 -> commands.get(5).execute();
        }
        return false;
    }
}