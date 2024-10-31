package Menu;

import Commands.*;
import SystemVouchers.SystemVouchers;
import Utilities.Utilities;
import Loggers.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    protected String title;
    protected ArrayList<Command> commands;
    protected ArrayList<Menu> subMenus;
    protected LoggerInfo logger;
    protected SystemVouchers systemVouchers;

    public Menu(String title, ArrayList<Command> commands, ArrayList<Menu> subMenus) {
        this.title = title;
        this.commands = commands;
        this.subMenus = subMenus;
        this.logger = LoggerInfo.getInstance();
        systemVouchers = SystemVouchers.getInstance();
    }

    public void startMenu() {
        boolean isRunning;
        Scanner scanner = new Scanner(System.in);

        if (systemVouchers.getVouchers().isEmpty() && !(this instanceof MenuMain)) {
            System.out.println("\n\tСписок вибраних путівок порожній.");
            System.out.print("\n\tНатисніть Enter, щоб продовжити...");
            scanner.nextLine();
            return;
        }

        do {
            Utilities.clearConsole();
            this.printMenu();
            isRunning = selectCommand();
        } while (isRunning);
    }

    public void printMenu() {
        System.out.printf("\t\t\t%s%n%n", title);
        int i = 0;
        while (i < commands.size()) {
            System.out.printf("\t %d - %s%n", i + 1, commands.get(i).getTitle());
            i++;
        }
        System.out.printf("\t %d - Вийти з меню%n", i + 1);
    }

    public String getTitle() {
        return title;
    }

    public boolean selectCommand() {
        int choice = Utilities.getValidatedInput(1, 2);

        return choice != 2;
    }

    public ArrayList<? extends Command> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }
}