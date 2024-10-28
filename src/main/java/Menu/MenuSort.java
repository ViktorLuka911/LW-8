package Menu;

import Commands.Command;
import Commands.GoToMenuCommand;
import Utilities.Utilities;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuSort extends Menu {
    public MenuSort() {

        // Ініціалізація списку підменю
        ArrayList<Menu> subMenus = new ArrayList<>(
                Arrays.asList(
                        new MenuSortOrder("Сортувати за кількістю днів"),
                        new MenuSortOrder("Сортувати за ціною"),
                        new MenuSortOrder("Сортувати за датою")
                )
        );

        // Ініціалізація списку команд
        ArrayList<Command> commands = new ArrayList<>(
                Arrays.asList(
                        new GoToMenuCommand("Сортувати за кількістю днів", subMenus.get(0)),
                        new GoToMenuCommand("Сортувати за ціною", subMenus.get(1)),
                        new GoToMenuCommand("Сортувати за датою", subMenus.get(2))
                )
        );

        super("Меню вибору типу сортування", commands, subMenus);
    }

    @Override
    public void printMenu() {
        System.out.println("\n\t\t\t"  + title + "\n");
        int i = 0;
        while (i < commands.size()) {
            System.out.println("\t " + (i + 1) + " - " + commands.get(i).getTitle());
            i++;
        }
    }

    @Override
    public boolean selectCommand() {
        int choice = Utilities.getValidatedInput(1, 3);

        switch (choice) {
            case 1 -> commands.get(0).execute();
            case 2 -> commands.get(1).execute();
            case 3 -> commands.get(2).execute();
        }

        return false;
    }
}