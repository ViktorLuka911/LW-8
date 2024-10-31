package Commands;

public class SortCommand extends Command {

    private String type;

    public SortCommand(String type, String title) {
        super(title);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void execute() {
        boolean ascending = getType().equals("За зростанням");

        switch (getTitle()) {
            case "Сортувати за кількістю днів":
                systemVouchers.sortVouchersByDays(ascending);
                logger.logInfo(String.format("Користувач вибрав сортування за кількістю днів у порядку %s.", ascending ? "зростання" : "спадання"));
                break;

            case "Сортувати за ціною":
                systemVouchers.sortVouchersByPrice(ascending);
                logger.logInfo(String.format("Користувач вибрав сортування за ціною путівки у порядку %s.", ascending ? "зростання" : "спадання"));
                break;

            case "Сортувати за датою":
                systemVouchers.sortVouchersByDate(ascending);
                logger.logInfo(String.format("Користувач вибрав сортування за датою путівки у порядку %s.", ascending ? "зростання" : "спадання"));
                break;
        }
        systemVouchers.showVouchers(true);
    }

    public void setType(String type) {
        this.type = type;
    }
}