package VoucherParameters;

public enum Budget {
    Low("Низький", 200),
    Medium("Середній", 400),
    High("Високий", 600);

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