package VoucherParameters;

public enum VoucherType {
    RECREATION("Відпочинок", 500, 14),
    EXCURSION("Екскурсія", 300, 10),
    TREATMENT("Лікування", 700, 21),
    SHOPPING("Шопінг", 400, 5),
    CRUISE("Круїз", 1000, 30),
    EXTREME_TOUR("Екстрим тур", 800, 7),
    EDU_TOUR("Еду тур", 600, 13),
    GASTRO_TOUR("Гастро тур", 500, 8);

    private final String translate;
    private final int price;
    private final int maxDays;

    VoucherType(String translate, int price, int maxDays) {
        this.translate = translate;
        this.price = price;
        this.maxDays = maxDays;
    }

    public int getPrice() {
        return price;
    }

    public  int getMaxDays() {
        return maxDays;
    }

    public static VoucherType fromString(String name) {
        for (VoucherType type : values()) {
            if (type.toString().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return translate;
    }
}