package VoucherParameters;

public enum VoucherType {
    Recreation("Відпочинок", 500, 14),
    Excursion("Екскурсія", 300, 10),
    Treatment("Лікування", 700, 21),
    Shopping("Шопінг", 400, 5),
    Cruise("Круїз", 1000, 30),
    ExtremeTour("Екстрим тур", 800, 7),
    EduTour("Еду тур", 600, 13),
    GastroTour("Гастро тур", 500, 8);

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