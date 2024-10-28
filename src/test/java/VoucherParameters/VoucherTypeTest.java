package VoucherParameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoucherTypeTest {

    @Test
    void testGetPrice() {
        assertEquals(500, VoucherType.Recreation.getPrice());
        assertEquals(300, VoucherType.Excursion.getPrice());
        assertEquals(700, VoucherType.Treatment.getPrice());
        assertEquals(400, VoucherType.Shopping.getPrice());
        assertEquals(1000, VoucherType.Cruise.getPrice());
        assertEquals(800, VoucherType.ExtremeTour.getPrice());
        assertEquals(600, VoucherType.EduTour.getPrice());
        assertEquals(500, VoucherType.GastroTour.getPrice());
    }

    @Test
    void testGetMaxDays() {
        assertEquals(14, VoucherType.Recreation.getMaxDays());
        assertEquals(10, VoucherType.Excursion.getMaxDays());
        assertEquals(21, VoucherType.Treatment.getMaxDays());
        assertEquals(5, VoucherType.Shopping.getMaxDays());
        assertEquals(30, VoucherType.Cruise.getMaxDays());
        assertEquals(7, VoucherType.ExtremeTour.getMaxDays());
        assertEquals(13, VoucherType.EduTour.getMaxDays());
        assertEquals(8, VoucherType.GastroTour.getMaxDays());
    }

    @Test
    void testFromStringWithValidNames() {
        assertEquals(VoucherType.Recreation, VoucherType.fromString("Відпочинок"));
        assertEquals(VoucherType.Excursion, VoucherType.fromString("Екскурсія"));
        assertEquals(VoucherType.Treatment, VoucherType.fromString("Лікування"));
        assertEquals(VoucherType.Shopping, VoucherType.fromString("Шопінг"));
        assertEquals(VoucherType.Cruise, VoucherType.fromString("Круїз"));
        assertEquals(VoucherType.ExtremeTour, VoucherType.fromString("Екстрим тур"));
        assertEquals(VoucherType.EduTour, VoucherType.fromString("Еду тур"));
        assertEquals(VoucherType.GastroTour, VoucherType.fromString("Гастро тур"));
    }

    @Test
    void testFromStringWithInvalidName() {
        assertNull(VoucherType.fromString("Невідомий"));
    }

    @Test
    void testToString() {
        assertEquals("Відпочинок", VoucherType.Recreation.toString());
        assertEquals("Екскурсія", VoucherType.Excursion.toString());
        assertEquals("Лікування", VoucherType.Treatment.toString());
        assertEquals("Шопінг", VoucherType.Shopping.toString());
        assertEquals("Круїз", VoucherType.Cruise.toString());
        assertEquals("Екстрим тур", VoucherType.ExtremeTour.toString());
        assertEquals("Еду тур", VoucherType.EduTour.toString());
        assertEquals("Гастро тур", VoucherType.GastroTour.toString());
    }
}