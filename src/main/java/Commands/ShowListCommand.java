package Commands;

import SelectParameters.SelectParameters;
import VoucherParameters.*;

public class ShowListCommand extends Command {

    public ShowListCommand(String title) {
        super(title);
    }

    @Override
    public void execute() {
        switch (title) {
            case "Вивести всі путівки":
                systemVouchers.resetVouchers();
                logger.logInfo("Користувач вибрав перегляд всього списку.");
                break;

            case "За типом":
                VoucherType type = SelectParameters.selectVoucherType();
                systemVouchers.setVouchersByType(type);
                logger.logInfo("Користувач вибрав фільтрацію списку за типом путівки.");
                break;

            case "За країною":
                Country country = SelectParameters.selectCountry();
                systemVouchers.setVouchersByCountry(country);
                logger.logInfo("Користувач вибрав фільтрацію списку за країною.");
                break;

            case "За транспортом":
                VoucherTransport transport = SelectParameters.selectTransport();
                systemVouchers.setVouchersByTransport(transport);
                logger.logInfo("Користувач вибрав фільтрацію списку за типом транспорту.");
                break;

            case "За бюджетом":
                Budget budget = SelectParameters.selectBudget();
                systemVouchers.setVouchersByBudget(budget);
                logger.logInfo("Користувач вибрав фільтрацію списку за типом бюджету.");
                break;

            case "За харчуванням":
                Nutrition nutrition = SelectParameters.selectNutrition();
                systemVouchers.setVouchersByNutrition(nutrition);
                logger.logInfo("Користувач вибрав фільтрацію списку за типом харчування.");
                break;
        }

        systemVouchers.showVouchers(true);
    }
}