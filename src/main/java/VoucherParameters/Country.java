package VoucherParameters;

public enum Country {
    France("Франція"),
    Germany("Німеччина"),
    Italy("Італія"),
    Spain("Іспанія"),
    USA("США"),
    Canada("Канада"),
    Brazil("Бразилія"),
    Australia("Австралія"),
    Japan("Японія"),
    Egypt("Єгипет"),
    Turkey("Туреччина"),
    UnitedKingdom("Велика Британія"),
    Sweden("Швеція"),
    Norway("Норвегія");

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