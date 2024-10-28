package Commands;

public class SortCommand extends Command {

    private final String type;

    public SortCommand(String type, String title) {
        super(title);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void execute() {
        boolean ascending = getTitle().equals("За зростанням");

        switch (getType()) {
            case "Сортувати за кількістю днів":
                systemVouchers.sortVouchersByDays(ascending);
                loggerInfo.logInfo(String.format("Користувач вибрав сортування за кількістю днів у порядку %s.", ascending ? "зростання" : "спадання"));
                break;

            case "Сортувати за ціною":
                systemVouchers.sortVouchersByPrice(ascending);
                loggerInfo.logInfo(String.format("Користувач вибрав сортування за ціною путівки у порядку %s.", ascending ? "зростання" : "спадання"));
                break;

            case "Сортувати за датою":
                systemVouchers.sortVouchersByDate(ascending);
                loggerInfo.logInfo(String.format("Користувач вибрав сортування за датою путівки у порядку %s.", ascending ? "зростання" : "спадання"));
                break;
        }
        systemVouchers.showVouchers(true);
    }
}