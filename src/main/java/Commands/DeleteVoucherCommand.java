package Commands;

import Utilities.Utilities;
import java.util.Scanner;

public class DeleteVoucherCommand extends Command {
    public DeleteVoucherCommand(String title) {
        super(title);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        if (systemVouchers.getVouchers().isEmpty()) {
            System.out.println("\n\tСписок вибраних путівок порожній.");
            System.out.print("\n\tНатисніть Enter, щоб продовжити...");
            scanner.nextLine();
            return;
        }

        systemVouchers.showVouchers(false);
        int choice = Utilities.getValidatedInput(1, systemVouchers.getVouchers().size());
        loggerInfo.logInfo(String.format(" Путівку видалено.%n%s", systemVouchers.getVouchers().get(choice - 1).toStringLogger()));
        systemVouchers.deleteVoucher(systemVouchers.getVouchers().get(choice - 1));
    }
}