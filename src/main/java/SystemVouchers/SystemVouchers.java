package SystemVouchers;

import VoucherParameters.*;
import Loggers.*;
import List.*;
import Voucher.Voucher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SystemVouchers {
    private static SystemVouchers instance;
    private ListVouchers vouchers;
    private final LoggerInfo logger;
    private final DataFileLogger dataFileLogger;

    private SystemVouchers() {
        vouchers = new ListVouchers();
        this.logger = LoggerInfo.getInstance();
        dataFileLogger = new DataFileLogger();
        dataFileLogger.init("logs/Datalog.txt", true);
        this.resetVouchers();
    }

    public static SystemVouchers getInstance() {
        if (instance == null) {
            instance = new SystemVouchers();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    public void showVouchers(boolean pressEnter) {
        Scanner scanner = new Scanner(System.in);
        if (vouchers.isEmpty()) {
            System.out.print("\n\tСписок вибраних путівок порожній.\n");
        } else {
            String header = String.format("\n\t%-5s%-25s%-20s%-20s%-20s%-15s%-8s%-15s%-15s",
                    "№", "Тип", "Країна", "Транспорт", "Харчування", "Бюджет", "Дні", "Дата", "Ціна");

            StringBuilder border = new StringBuilder();
            border.append("-".repeat(Math.max(0, header.length() - 9)));
            System.out.printf("\t%s%n", header);
            System.out.printf("\t%s%n", border);

            int counter = 1;
            for (Voucher voucher : vouchers.getList()) {
                System.out.printf("\t%-5d %s%n", counter, voucher);
                counter++;
            }

            System.out.printf("\t%s%n", border);

            if (pressEnter) {
                System.out.print("\n\tНатисніть Enter, щоб продовжити...");
                scanner.nextLine();
            }
        }
    }

    public ListVouchers getVouchers() {
        return vouchers;
    }

    public void setVouchers(ListVouchers list) {
        vouchers = list;
    }

    public void addVoucher(Voucher selectedVoucher) {
        if (vouchers != null) {
            vouchers.add(selectedVoucher);
            dataFileLogger.log(selectedVoucher.toString());
            System.out.println("\n\n\tПутівку успішно додано до списку.");
        } else {
            System.out.println("\n\tСписок вибраних путівок не ініціалізований.");
        }
    }

    public void deleteVoucher(Voucher selectedVoucher) {
        if (vouchers.getList().remove(selectedVoucher)) {

            ListVouchers buffer = new ListVouchers();

            try (BufferedReader br = new BufferedReader(new FileReader("logs/Datalog.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    buffer.add(Voucher.fromString(line));
                }
            } catch (IOException e) {
                logger.logError("Помилка при читанні файлу бази даних.", "");
            }

            buffer.getList().remove(selectedVoucher);

            dataFileLogger.init("logs/Datalog.txt", false);

            for (Voucher voucher : buffer.getList()) {
                dataFileLogger.log(voucher.toString());
            }

            System.out.println("\n\tПутівку успішно видалено.");
        } else {
            System.out.println("\n\tПутівку не знайдено.");
        }
    }

    public void resetVouchers() {
        vouchers.clear();

        try (BufferedReader br = new BufferedReader(new FileReader("logs/Datalog.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                vouchers.add(Voucher.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("\n\tСталася помилка при перезавантаженні ваучерів.\n");
            logger.logError("Помилка при читанні файлу бази даних.", "");
        }
    }

    public void setVouchersByType(VoucherType type) {
        vouchers = vouchers.getByType(type);
    }

    public void setVouchersByCountry(Country country) {
        vouchers = vouchers.getByCountry(country);
    }

    public void setVouchersByTransport(VoucherTransport transport) {
        vouchers = vouchers.getByTransport(transport);
    }

    public void setVouchersByNutrition(Nutrition nutrition) {
        vouchers = vouchers.getByNutrition(nutrition);
    }

    public void setVouchersByBudget(Budget budget) {
        vouchers = vouchers.getByBudget(budget);
    }

    public void sortVouchersByDays(boolean ascending) {
        vouchers.sortByDays(ascending);
    }

    public void sortVouchersByPrice(boolean ascending) {
        vouchers.sortByPrice(ascending);
    }

    public void sortVouchersByDate(boolean ascending) {
        vouchers.sortByDate(ascending);
    }

    public void closeDataFileLogger() {
        dataFileLogger.close();
    }
}