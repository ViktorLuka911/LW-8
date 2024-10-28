package Menu;

import Commands.*;
import Utilities.Utilities;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuMain extends Menu {
    public MenuMain() {

        // Ініціалізація списку підменю
        ArrayList<Menu> subMenus = new ArrayList<>(
                Arrays.asList(
                        new MenuCategory(),
                        new MenuSort()
                )
        );

        // Ініціалізація списку команд
        ArrayList<Command> commands = new ArrayList<>(
                Arrays.asList(
                        new ReferenceCommand("Довідка"),
                        new ShowListCommand("Поточний список"),
                        new AddVoucherCommand("Додати путівку"),
                        new GoToMenuCommand("Путівки за категорією", subMenus.get(0)),
                        new GoToMenuCommand("Посортувати путівки", subMenus.get(1)),
                        new DeleteVoucherCommand("Видалити путівку")
                )
        );

        // Виклик конструктора батьківського класу з аргументами
        super("Головне меню", commands, subMenus);
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

        return isRunning;
    }
}