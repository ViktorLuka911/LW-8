import Loggers.LoggerInfo;
import Menu.MenuMain;
import SystemVouchers.SystemVouchers;

public class Main {
    public static void main(String[] args) {
        SystemVouchers systemVouchers = SystemVouchers.getInstance();

        LoggerInfo logger = LoggerInfo.getInstance();
        logger.logInfo("Користувач увійшов у програму");

        MenuMain menu = new MenuMain();
        menu.startMenu();

        logger.logInfo("Користувач вийшов з програми");

        systemVouchers.closeDataFileLogger();
    }
}