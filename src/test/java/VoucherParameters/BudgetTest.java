package VoucherParameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetTest {

    @Test
    void testGetPrice() {
        assertEquals(200, Budget.Low.getPrice());
        assertEquals(400, Budget.Medium.getPrice());
        assertEquals(600, Budget.High.getPrice());
    }

    @Test
    void testFromStringValid() {
        assertEquals(Budget.Low, Budget.fromString("Низький"));
        assertEquals(Budget.Medium, Budget.fromString("Середній"));
        assertEquals(Budget.High, Budget.fromString("Високий"));
    }

    @Test
    void testFromStringInvalid() {
        assertNull(Budget.fromString("Невідомий"));
    }

    @Test
    void testToString() {
        assertEquals("Низький", Budget.Low.toString());
        assertEquals("Середній", Budget.Medium.toString());
        assertEquals("Високий", Budget.High.toString());
    }
}