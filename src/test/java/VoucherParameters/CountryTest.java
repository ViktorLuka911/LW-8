package VoucherParameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void testFromStringValid() {
        assertEquals(Country.France, Country.fromString("Франція"));
        assertEquals(Country.Germany, Country.fromString("Німеччина"));
        assertEquals(Country.Italy, Country.fromString("Італія"));
        assertEquals(Country.Spain, Country.fromString("Іспанія"));
        assertEquals(Country.USA, Country.fromString("США"));
        assertEquals(Country.Canada, Country.fromString("Канада"));
        assertEquals(Country.Brazil, Country.fromString("Бразилія"));
        assertEquals(Country.Australia, Country.fromString("Австралія"));
        assertEquals(Country.Japan, Country.fromString("Японія"));
        assertEquals(Country.Egypt, Country.fromString("Єгипет"));
        assertEquals(Country.Turkey, Country.fromString("Туреччина"));
        assertEquals(Country.UnitedKingdom, Country.fromString("Велика Британія"));
        assertEquals(Country.Sweden, Country.fromString("Швеція"));
        assertEquals(Country.Norway, Country.fromString("Норвегія"));
    }

    @Test
    void testFromStringInvalid() {
        assertNull(Country.fromString("Невідомий"));
    }

    @Test
    void testToString() {
        assertEquals("Франція", Country.France.toString());
        assertEquals("Німеччина", Country.Germany.toString());
        assertEquals("Італія", Country.Italy.toString());
        assertEquals("Іспанія", Country.Spain.toString());
        assertEquals("США", Country.USA.toString());
        assertEquals("Канада", Country.Canada.toString());
        assertEquals("Бразилія", Country.Brazil.toString());
        assertEquals("Австралія", Country.Australia.toString());
        assertEquals("Японія", Country.Japan.toString());
        assertEquals("Єгипет", Country.Egypt.toString());
        assertEquals("Туреччина", Country.Turkey.toString());
        assertEquals("Велика Британія", Country.UnitedKingdom.toString());
        assertEquals("Швеція", Country.Sweden.toString());
        assertEquals("Норвегія", Country.Norway.toString());
    }
}