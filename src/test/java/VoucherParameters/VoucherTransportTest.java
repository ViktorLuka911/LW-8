package VoucherParameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoucherTransportTest {

    @Test
    void testGetPrice() {
        assertEquals(300, VoucherTransport.Plane.getPrice());
        assertEquals(150, VoucherTransport.Train.getPrice());
        assertEquals(100, VoucherTransport.Bus.getPrice());
        assertEquals(50, VoucherTransport.Car.getPrice());
        assertEquals(0, VoucherTransport.None.getPrice());
    }

    @Test
    void testFromStringWithValidNames() {
        assertEquals(VoucherTransport.Plane, VoucherTransport.fromString("Літак"));
        assertEquals(VoucherTransport.Train, VoucherTransport.fromString("Потяг"));
        assertEquals(VoucherTransport.Bus, VoucherTransport.fromString("Автобус"));
        assertEquals(VoucherTransport.Car, VoucherTransport.fromString("Машина"));
        assertEquals(VoucherTransport.None, VoucherTransport.fromString("Відсутній"));
    }

    @Test
    void testFromStringWithInvalidName() {
        assertNull(VoucherTransport.fromString("Unknown"));
    }

    @Test
    void testToString() {
        assertEquals("Літак", VoucherTransport.Plane.toString());
        assertEquals("Потяг", VoucherTransport.Train.toString());
        assertEquals("Автобус", VoucherTransport.Bus.toString());
        assertEquals("Машина", VoucherTransport.Car.toString());
        assertEquals("Відсутній", VoucherTransport.None.toString());
    }
}