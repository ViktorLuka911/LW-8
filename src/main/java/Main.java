import Loggers.LoggerInfo;
import Menu.MenuMain;
import SystemVouchers.SystemVouchers;

public class Main {
    public static void main() {
        LoggerInfo logger = LoggerInfo.getInstance();

        try {
            SystemVouchers systemVouchers = SystemVouchers.getInstance();

            logger.logInfo("Користувач увійшов у програму.");

            MenuMain menu = new MenuMain();
            menu.startMenu();

            logger.logInfo("Користувач вийшов з програми.");

            systemVouchers.closeDataFileLogger();
        } catch (Exception e) {
            logger.logError("Помилка у програмі.", e.getMessage() + '.');
        }
    }
}