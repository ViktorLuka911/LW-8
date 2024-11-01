package VoucherParameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoucherTransportTest {

    @Test
    void testGetPrice() {
        assertEquals(300, VoucherTransport.PLANE.getPrice());
        assertEquals(150, VoucherTransport.TRAIN.getPrice());
        assertEquals(100, VoucherTransport.BUS.getPrice());
        assertEquals(50, VoucherTransport.CAR.getPrice());
        assertEquals(0, VoucherTransport.NONE.getPrice());
    }

    @Test
    void testFromStringValid() {
        assertEquals(VoucherTransport.PLANE, VoucherTransport.fromString("Літак"));
        assertEquals(VoucherTransport.TRAIN, VoucherTransport.fromString("Потяг"));
        assertEquals(VoucherTransport.BUS, VoucherTransport.fromString("Автобус"));
        assertEquals(VoucherTransport.CAR, VoucherTransport.fromString("Машина"));
        assertEquals(VoucherTransport.NONE, VoucherTransport.fromString("Відсутній"));
    }

    @Test
    void testFromStringInvalid() {
        assertNull(VoucherTransport.fromString("Невідомий"));
    }

    @Test
    void testToString() {
        assertEquals("Літак", VoucherTransport.PLANE.toString());
        assertEquals("Потяг", VoucherTransport.TRAIN.toString());
        assertEquals("Автобус", VoucherTransport.BUS.toString());
        assertEquals("Машина", VoucherTransport.CAR.toString());
        assertEquals("Відсутній", VoucherTransport.NONE.toString());
    }
}