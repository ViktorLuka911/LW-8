package VoucherParameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoucherTypeTest {

    @Test
    void testGetPrice() {
        assertEquals(500, VoucherType.RECREATION.getPrice());
        assertEquals(300, VoucherType.EXCURSION.getPrice());
        assertEquals(700, VoucherType.TREATMENT.getPrice());
        assertEquals(400, VoucherType.SHOPPING.getPrice());
        assertEquals(1000, VoucherType.CRUISE.getPrice());
        assertEquals(800, VoucherType.EXTREME_TOUR.getPrice());
        assertEquals(600, VoucherType.EDU_TOUR.getPrice());
        assertEquals(500, VoucherType.GASTRO_TOUR.getPrice());
    }

    @Test
    void testGetMaxDays() {
        assertEquals(14, VoucherType.RECREATION.getMaxDays());
        assertEquals(10, VoucherType.EXCURSION.getMaxDays());
        assertEquals(21, VoucherType.TREATMENT.getMaxDays());
        assertEquals(5, VoucherType.SHOPPING.getMaxDays());
        assertEquals(30, VoucherType.CRUISE.getMaxDays());
        assertEquals(7, VoucherType.EXTREME_TOUR.getMaxDays());
        assertEquals(13, VoucherType.EDU_TOUR.getMaxDays());
        assertEquals(8, VoucherType.GASTRO_TOUR.getMaxDays());
    }

    @Test
    void testFromStringValid() {
        assertEquals(VoucherType.RECREATION, VoucherType.fromString("Відпочинок"));
        assertEquals(VoucherType.EXCURSION, VoucherType.fromString("Екскурсія"));
        assertEquals(VoucherType.TREATMENT, VoucherType.fromString("Лікування"));
        assertEquals(VoucherType.SHOPPING, VoucherType.fromString("Шопінг"));
        assertEquals(VoucherType.CRUISE, VoucherType.fromString("Круїз"));
        assertEquals(VoucherType.EXTREME_TOUR, VoucherType.fromString("Екстрим тур"));
        assertEquals(VoucherType.EDU_TOUR, VoucherType.fromString("Еду тур"));
        assertEquals(VoucherType.GASTRO_TOUR, VoucherType.fromString("Гастро тур"));
    }

    @Test
    void testFromStringInvalid() {
        assertNull(VoucherType.fromString("Невідомий"));
    }

    @Test
    void testToString() {
        assertEquals("Відпочинок", VoucherType.RECREATION.toString());
        assertEquals("Екскурсія", VoucherType.EXCURSION.toString());
        assertEquals("Лікування", VoucherType.TREATMENT.toString());
        assertEquals("Шопінг", VoucherType.SHOPPING.toString());
        assertEquals("Круїз", VoucherType.CRUISE.toString());
        assertEquals("Екстрим тур", VoucherType.EXTREME_TOUR.toString());
        assertEquals("Еду тур", VoucherType.EDU_TOUR.toString());
        assertEquals("Гастро тур", VoucherType.GASTRO_TOUR.toString());
    }
}