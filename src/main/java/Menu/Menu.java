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
    protected LoggerInfo loggerInfo;
    protected SystemVouchers systemVouchers;

    public Menu(String title, ArrayList<Command> commands, ArrayList<Menu> subMenus) {
        this.title = title;
        this.commands = commands;
        this.subMenus = subMenus;
        this.loggerInfo = LoggerInfo.getInstance();
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
        System.out.println("\t\t\t" + title + "\n");
        int i = 0;
        while (i < commands.size()) {
            System.out.println("\t " + (i + 1) + " - " + commands.get(i).getTitle());
            i++;
        }
        System.out.println("\t " + (i + 1) + " - Вийти з меню");
    }

    public String getTitle() {
        return title;
    }

    public boolean selectCommand() {
        int choice = Utilities.getValidatedInput(1, 2);
        boolean isRunning = true;

        switch (choice) {
            case 1 -> isRunning = true;
            case 2 -> isRunning = false;
        }

        return isRunning;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }
}