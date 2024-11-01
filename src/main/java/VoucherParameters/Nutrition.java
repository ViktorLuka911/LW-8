package VoucherParameters;

public enum Nutrition {
    ALL_INCLUSIVE("Все включено", 100),
    NONE("Без харчування", 0);

    private final String translate;
    private final int price;

    Nutrition(String translate, int price) {
        this.translate = translate;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static Nutrition fromString(String name) {
        for (Nutrition nutrition : values()) {
            if (nutrition.toString().equalsIgnoreCase(name)) {
                return nutrition;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return translate;
    }
}