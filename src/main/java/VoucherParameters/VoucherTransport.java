package VoucherParameters;

public enum VoucherTransport {
    Plane("Літак", 300),
    Train("Потяг", 150),
    Bus("Автобус", 100),
    Car("Машина", 50),
    None("Відсутній", 0);

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