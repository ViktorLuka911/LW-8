package VoucherParameters;

public enum Budget {
    LOW("Низький", 200),
    MEDIUM("Середній", 400),
    HIGH("Високий", 600);

    private final String translate;
    private final int price;

    Budget(String translate, int price) {
        this.translate = translate;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static Budget fromString(String name) {
        for (Budget budget : values()) {
            if (budget.toString().equalsIgnoreCase(name)) {
                return budget;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return translate;
    }
}