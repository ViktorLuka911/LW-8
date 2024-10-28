package Menu;

import Commands.Command;
import Commands.SortCommand;
import Utilities.Utilities;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuSortOrder extends Menu {

    public MenuSortOrder(String type) {

        ArrayList<Menu> subMenus = new ArrayList<>();

        ArrayList<Command> commands = new ArrayList<>(
                Arrays.asList(
                        new SortCommand(type, "За зростанням"),
                        new SortCommand(type, "За спаданням")
                )
        );

        super("Меню вибору порядку сортування", commands, subMenus);
    }

    @Override
    public void printMenu() {
        System.out.printf("\n\t\t\t%s%n%n", title);
        int i = 0;
        while (i < commands.size()) {
            System.out.printf("\t %d - %s%n", i + 1, commands.get(i).getTitle());
            i++;
        }
    }

    @Override
    public boolean selectCommand() {
        int choice = Utilities.getValidatedInput(1, 2);

        switch (choice) {
            case 1 -> commands.get(0).execute();
            case 2 -> commands.get(1).execute();
        }

        return false;
    }
}