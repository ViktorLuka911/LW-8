package VoucherParameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NutritionTest {

    @Test
    void testGetPrice() {
        assertEquals(100, Nutrition.ALL_INCLUSIVE.getPrice());
        assertEquals(0, Nutrition.NONE.getPrice());
    }

    @Test
    void testFromStringValid() {
        assertEquals(Nutrition.ALL_INCLUSIVE, Nutrition.fromString("Все включено"));
        assertEquals(Nutrition.NONE, Nutrition.fromString("Без харчування"));
    }

    @Test
    void testFromStringInvalid() {
        assertNull(Nutrition.fromString("Невідомий"));
    }

    @Test
    void testToString() {
        assertEquals("Все включено", Nutrition.ALL_INCLUSIVE.toString());
        assertEquals("Без харчування", Nutrition.NONE.toString());
    }
}