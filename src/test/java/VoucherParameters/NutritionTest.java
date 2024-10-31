package VoucherParameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NutritionTest {

    @Test
    void testGetPrice() {
        assertEquals(100, Nutrition.AllInclusive.getPrice());
        assertEquals(0, Nutrition.NoMeals.getPrice());
    }

    @Test
    void testFromStringValid() {
        assertEquals(Nutrition.AllInclusive, Nutrition.fromString("Все включено"));
        assertEquals(Nutrition.NoMeals, Nutrition.fromString("Без харчування"));
    }

    @Test
    void testFromStringInvalid() {
        assertNull(Nutrition.fromString("Невідомий"));
    }

    @Test
    void testToString() {
        assertEquals("Все включено", Nutrition.AllInclusive.toString());
        assertEquals("Без харчування", Nutrition.NoMeals.toString());
    }
}