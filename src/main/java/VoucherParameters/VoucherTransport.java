package VoucherParameters;

public enum VoucherTransport {
    PLANE("Літак", 300),
    TRAIN("Потяг", 150),
    BUS("Автобус", 100),
    CAR("Машина", 50),
    NONE("Відсутній", 0);

    private final String translate;
    private final int price;

    VoucherTransport(String translate, int price) {
        this.translate = translate;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static VoucherTransport fromString(String name) {
        for (VoucherTransport transport : values()) {
            if (transport.toString().equalsIgnoreCase(name)) {
                return transport;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return translate;
    }
}