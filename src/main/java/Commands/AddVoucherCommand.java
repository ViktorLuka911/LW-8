package Commands;

import Voucher.Voucher;
import java.util.Scanner;

public class AddVoucherCommand extends Command {

    public AddVoucherCommand(String title) {
        super(title);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Voucher newVoucher = new Voucher();
        systemVouchers.addVoucher(newVoucher);

        loggerInfo.logInfo(String.format("\tПутівку додано.%n%s", newVoucher.toStringLogger()));

        System.out.print("\n\tНатисніть Enter, щоб продовжити...");
        scanner.nextLine();
    }
}