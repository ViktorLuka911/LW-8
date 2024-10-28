package Voucher;

import SelectParameters.SelectParameters;
import Utilities.Utilities;
import VoucherParameters.*;
import java.util.Objects;
import java.time.LocalDate;

public class Voucher {
    private Country country;
    private int price;

    private VoucherType type;
    private VoucherTransport transport;
    private Nutrition nutrition;
    private Budget budget;
    private int numberOfDays;
    private LocalDate tripDate;

    public Voucher() {
        selectType();
        selectCountry();
        selectTransport();
        selectNutrition();
        selectBudget();
        selectNumberOfDays();
        selectDate();
    }

    public Voucher(Country country, int price, VoucherType type, VoucherTransport transport, Nutrition nutrition, Budget budget, int numberOfDays, LocalDate tripDate) {
        this.country = country;
        this.price = price;
        this.type = type;
        this.transport = transport;
        this.nutrition = nutrition;
        this.budget = budget;
        this.numberOfDays = numberOfDays;
        this.tripDate = tripDate;
    }

    public String toStringLogger() {
        return String.format(
                "Тип: %s%nКраїна: %s%nТранспорт: %s%nХарчування: %s%nБюджет: %s%nКількість днів: %d%nДата поїздки: %s%nЦіна: %d",
                type, country, transport, nutrition, budget, numberOfDays, tripDate, price
        );
    }

    public static Voucher fromString(String line) {
        String typeString = line.substring(0, 25).trim();
        String countryString = line.substring(25, 45).trim();
        String transportString = line.substring(45, 65).trim();
        String nutritionString = line.substring(65, 85).trim();
        String budgetString = line.substring(85, 100).trim();
        String numberOfDaysString = line.substring(100, 108).trim();
        String tripDateString = line.substring(108, 123).trim();
        String priceString = line.substring(123).trim();

        VoucherType type = VoucherType.fromString(typeString);
        Country country = Country.fromString(countryString);
        VoucherTransport transport = VoucherTransport.fromString(transportString);
        Nutrition nutrition = Nutrition.fromString(nutritionString);
        Budget budget = Budget.fromString(budgetString);
        int numberOfDays = Integer.parseInt(numberOfDaysString);
        LocalDate tripDate = LocalDate.parse(tripDateString);
        int price = Integer.parseInt(priceString);

        return new Voucher(country, price, type, transport, nutrition, budget, numberOfDays, tripDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Voucher other)) {
            return false;
        }

        return country == other.country &&
                price == other.price &&
                type == other.type &&
                transport == other.transport &&
                nutrition == other.nutrition &&
                budget == other.budget &&
                numberOfDays == other.numberOfDays &&
                Objects.equals(tripDate, other.tripDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, price, type, transport, nutrition, budget, numberOfDays, tripDate);
    }

    @Override
    public String toString() {
        String format = "%-25s%-20s%-20s%-20s%-15s%-8s%-15s%-15s";

        return String.format(format,
                type,
                country,
                transport,
                nutrition,
                budget,
                numberOfDays,
                tripDate.toString(),
                price);
    }

    public int getPrice() {
        return price;
    }

    public VoucherType getType() { // Змінено тип повернення на VoucherType
        return type;
    }

    public Country getCountry() {
        return country;
    }

    public LocalDate getVoucherDate() {
        return tripDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public VoucherTransport getTransport() {
        return transport;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setType(VoucherType type) {
        this.type = type;
    }

    public void setTransport(VoucherTransport transport) {
        this.transport = transport;
    }

    public void setNutrition(Nutrition food) {
        this.nutrition = food;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public void setTripDate(LocalDate tripDate) {
        LocalDate currentDate = LocalDate.now();
        LocalDate maxDate = currentDate.plusYears(1); // Maximum date is one year from now

        if (tripDate.isBefore(currentDate) || tripDate.isAfter(maxDate)) {
            throw new IllegalArgumentException("Дата путівки повинна бути в межах одного року від сьогодні.");
        }
        this.tripDate = tripDate;
    }

    public void selectBudget() {
        Budget selectedBudget = SelectParameters.selectBudget();
        setBudget(selectedBudget);

        setPrice(getPrice() + selectedBudget.getPrice());

        System.out.printf("\n\tВи обрали: %s\n", selectedBudget);
        System.out.printf("\tЦіна оновлена: %d\n", getPrice());
    }

    public void selectCountry() {
        Country selectedCountry = SelectParameters.selectCountry();
        setCountry(selectedCountry);

        System.out.printf("\n\tВи обрали: %s\n", selectedCountry);
        System.out.printf("\tЦіна оновлена: %d\n", getPrice());
    }

    public void selectDate() {
        System.out.print("\n\tВведіть дату путівки (формат: YYYY-MM-DD): ");
        String inputDate = Utilities.getValidatedDateInput();

        LocalDate tripDate = LocalDate.parse(inputDate);

        setTripDate(tripDate);
    }

    public void selectNumberOfDays() {
        int minDays = 1;
        int maxDays = getType().getMaxDays();

        System.out.printf("\n\n\tВведіть кількість днів (%d - %d)", minDays, maxDays);
        int numberOfDays = Utilities.getValidatedInput(minDays, maxDays);

        setNumberOfDays(numberOfDays);
        int totalPrice = getType().getPrice() * numberOfDays;
        System.out.printf("\n\tЗагальна ціна за %d днів: %d\n", numberOfDays, totalPrice);
        setPrice(getPrice() + totalPrice);
        System.out.printf("\n\tЦіна оновлена: %d\n", getPrice());

    }

    public void selectNutrition() {
        Nutrition selectedNutrition;

        if (getType().toString().equals("Лікування") || getType().toString().equals("Круїз")) {
            selectedNutrition = Nutrition.values()[0];
        } else {
            selectedNutrition = SelectParameters.selectNutrition();
        }

        setPrice(getPrice() + selectedNutrition.getPrice());
        setNutrition(selectedNutrition);


        System.out.printf("\n\tВи обрали: %s\n", selectedNutrition);
        System.out.printf("\tЦіна оновлена: %d\n", getPrice());
    }

    public void selectTransport() {
        VoucherTransport selectedTransport = SelectParameters.selectTransport();

        setTransport(selectedTransport);
        setPrice(getPrice() + selectedTransport.getPrice());

        System.out.printf("\n\tВи обрали: %s\n", selectedTransport);
        System.out.printf("\tЦіна оновлена: %d\n", getPrice());
    }

    public void selectType() {
        VoucherType selectedType = SelectParameters.selectVoucherType();
        setType(selectedType);

        setPrice(getPrice() + selectedType.getPrice());

        System.out.printf("\n\tВи обрали: %s\n", selectedType);
        System.out.printf("\tЦіна оновлена: %d\n", getPrice());
    }
}