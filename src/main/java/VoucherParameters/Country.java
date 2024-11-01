package VoucherParameters;

public enum Country {
    FRANCE("Франція"),
    GERMANY("Німеччина"),
    ITALY("Італія"),
    SPAIN("Іспанія"),
    USA("США"),
    CANADA("Канада"),
    BRAZIL("Бразилія"),
    AUSTRALIA("Австралія"),
    JAPAN("Японія"),
    EGYPT("Єгипет"),
    TURKEY("Туреччина"),
    UNITED_KINGDOM("Велика Британія"),
    SWEDEN("Швеція"),
    NORWAY("Норвегія");

    private final String translate;

    Country(String translate) {
        this.translate = translate;
    }

    public static Country fromString(String name) {
        for (Country country : values()) {
            if (country.toString().equalsIgnoreCase(name)) {
                return country;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return translate;
    }
}