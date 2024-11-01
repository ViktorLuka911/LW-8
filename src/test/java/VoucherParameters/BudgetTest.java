package VoucherParameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetTest {

    @Test
    void testGetPrice() {
        assertEquals(200, Budget.LOW.getPrice());
        assertEquals(400, Budget.MEDIUM.getPrice());
        assertEquals(600, Budget.HIGH.getPrice());
    }

    @Test
    void testFromStringValid() {
        assertEquals(Budget.LOW, Budget.fromString("Низький"));
        assertEquals(Budget.MEDIUM, Budget.fromString("Середній"));
        assertEquals(Budget.HIGH, Budget.fromString("Високий"));
    }

    @Test
    void testFromStringInvalid() {
        assertNull(Budget.fromString("Невідомий"));
    }

    @Test
    void testToString() {
        assertEquals("Низький", Budget.LOW.toString());
        assertEquals("Середній", Budget.MEDIUM.toString());
        assertEquals("Високий", Budget.HIGH.toString());
    }
}