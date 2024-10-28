package SelectParameters;

import Utilities.Utilities;
import VoucherParameters.*;

public class SelectParameters {
    static public Country selectCountry() {
        System.out.println("\n\n\tВиберіть країну:\n");

        for (Country country : Country.values()) {
            System.out.printf("\t%d - %s%n", country.ordinal() + 1, country);
        }

        int choice = Utilities.getValidatedInput(1, Country.values().length);
        return Country.values()[choice - 1];
    }

    static public VoucherType selectVoucherType() {
        System.out.println("\n\n\tВиберіть тип путівки:\n");

        for (VoucherType type : VoucherType.values()) {
            System.out.printf("\t%d - %s%n", type.ordinal() + 1, type);
        }

        int choice = Utilities.getValidatedInput(1, VoucherType.values().length);

        return VoucherType.values()[choice - 1];
    }

    static public VoucherTransport selectTransport() {
        System.out.println("\n\n\tВиберіть транспорт:\n");

        for (VoucherTransport transport : VoucherTransport.values()) {
            System.out.printf("\t%d - %s%n", transport.ordinal() + 1, transport);
        }

        int choice = Utilities.getValidatedInput(1, VoucherTransport.values().length);

        return VoucherTransport.values()[choice - 1];
    }

    static public Nutrition selectNutrition() {
        System.out.println("\n\n\tВиберіть тип харчування:\n");

        for (Nutrition nutrition : Nutrition.values()) {
            System.out.printf("\t%d - %s%n", nutrition.ordinal() + 1, nutrition);
        }

        int choice = Utilities.getValidatedInput(1, Nutrition.values().length);

        return Nutrition.values()[choice - 1];
    }

    static public Budget selectBudget() {
        System.out.println("\n\n\tВиберіть бюджет:\n");

        for (Budget budget : Budget.values()) {
            System.out.printf("\t%d - %s%n", budget.ordinal() + 1, budget);
        }

        int choice = Utilities.getValidatedInput(1, Budget.values().length);

        return Budget.values()[choice - 1];
    }
}