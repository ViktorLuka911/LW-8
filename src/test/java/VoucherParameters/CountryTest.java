package VoucherParameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void testFromStringValid() {
        assertEquals(Country.FRANCE, Country.fromString("Франція"));
        assertEquals(Country.GERMANY, Country.fromString("Німеччина"));
        assertEquals(Country.ITALY, Country.fromString("Італія"));
        assertEquals(Country.SPAIN, Country.fromString("Іспанія"));
        assertEquals(Country.USA, Country.fromString("США"));
        assertEquals(Country.CANADA, Country.fromString("Канада"));
        assertEquals(Country.BRAZIL, Country.fromString("Бразилія"));
        assertEquals(Country.AUSTRALIA, Country.fromString("Австралія"));
        assertEquals(Country.JAPAN, Country.fromString("Японія"));
        assertEquals(Country.EGYPT, Country.fromString("Єгипет"));
        assertEquals(Country.TURKEY, Country.fromString("Туреччина"));
        assertEquals(Country.UNITED_KINGDOM, Country.fromString("Велика Британія"));
        assertEquals(Country.SWEDEN, Country.fromString("Швеція"));
        assertEquals(Country.NORWAY, Country.fromString("Норвегія"));
    }

    @Test
    void testFromStringInvalid() {
        assertNull(Country.fromString("Невідомий"));
    }

    @Test
    void testToString() {
        assertEquals("Франція", Country.FRANCE.toString());
        assertEquals("Німеччина", Country.GERMANY.toString());
        assertEquals("Італія", Country.ITALY.toString());
        assertEquals("Іспанія", Country.SPAIN.toString());
        assertEquals("США", Country.USA.toString());
        assertEquals("Канада", Country.CANADA.toString());
        assertEquals("Бразилія", Country.BRAZIL.toString());
        assertEquals("Австралія", Country.AUSTRALIA.toString());
        assertEquals("Японія", Country.JAPAN.toString());
        assertEquals("Єгипет", Country.EGYPT.toString());
        assertEquals("Туреччина", Country.TURKEY.toString());
        assertEquals("Велика Британія", Country.UNITED_KINGDOM.toString());
        assertEquals("Швеція", Country.SWEDEN.toString());
        assertEquals("Норвегія", Country.NORWAY.toString());
    }
}