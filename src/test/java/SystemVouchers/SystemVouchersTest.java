package SystemVouchers;

import List.ListVouchers;
import VoucherParameters.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import Voucher.Voucher;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SystemVouchersTest {

    private SystemVouchers systemVouchers;
    private Voucher voucher1;
    private Voucher voucher2;
    private Voucher voucher3;

    @BeforeEach
    void setUp() {
        SystemVouchers.resetInstance();
        systemVouchers = SystemVouchers.getInstance();
        systemVouchers.getVouchers().clear();

        voucher1 = new Voucher(Country.Italy, 2600,
                VoucherType.Excursion, VoucherTransport.Train,
                Nutrition.AllInclusive, Budget.Low,
                10, LocalDate.of(2024, 11, 15));

        voucher2 = new Voucher(Country.Germany, 1200,
                VoucherType.Recreation, VoucherTransport.Plane,
                Nutrition.AllInclusive, Budget.Medium,
                13, LocalDate.of(2024, 12, 11));

        voucher3 = new Voucher(Country.Italy, 3000,
                VoucherType.Shopping, VoucherTransport.Plane,
                Nutrition.NoMeals, Budget.Medium,
                5, LocalDate.of(2024, 10, 25));

        systemVouchers.getVouchers().add(voucher1);
        systemVouchers.getVouchers().add(voucher2);
        systemVouchers.getVouchers().add(voucher3);

    }

    @Test
    void testInstance() {
        SystemVouchers instance1 = SystemVouchers.getInstance();
        SystemVouchers instance2 = SystemVouchers.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void testAddVoucher() {
        Voucher voucher = new Voucher(Country.Italy, 2700,
                VoucherType.Excursion, VoucherTransport.Train,
                Nutrition.AllInclusive, Budget.Low,
                10, LocalDate.of(2024, 11, 15));
        systemVouchers.addVoucher(voucher);

        assertEquals(systemVouchers.getVouchers().get(3), voucher);

        systemVouchers.deleteVoucher(voucher);
    }

    @Test
    void testDeleteVoucherFound() {
        systemVouchers.deleteVoucher(voucher3);

        assertEquals(2, systemVouchers.getVouchers().size());
        assertEquals(voucher1, systemVouchers.getVouchers().get(0));
        assertEquals(voucher2, systemVouchers.getVouchers().get(1));
    }

    @Test
    void testDeleteVoucherNotFound() {
        Voucher voucher = new Voucher(Country.Italy, 2700,
                VoucherType.Excursion, VoucherTransport.Train,
                Nutrition.AllInclusive, Budget.Low,
                10, LocalDate.of(2024, 11, 15));
        systemVouchers.deleteVoucher(voucher);

        assertTrue(true);
    }

    @Test
    void testAddVoucherNull() {
        Voucher voucher = new Voucher(Country.Italy, 2700,
                VoucherType.Excursion, VoucherTransport.Train,
                Nutrition.AllInclusive, Budget.Low,
                10, LocalDate.of(2024, 11, 15));
        systemVouchers.setVouchers(null);
        systemVouchers.addVoucher(voucher);

        assertTrue(true);
    }

    @Test
    void testSetVouchers() {
        ListVouchers list = new ListVouchers();
        list.add(voucher1);
        list.add(voucher2);
        systemVouchers.setVouchers(list);

        assertEquals(list, systemVouchers.getVouchers());
    }

    @Test
    void testShowVouchersEmpty() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        systemVouchers.getVouchers().clear();
        System.setOut(new PrintStream(outContent));

        systemVouchers.showVouchers(false);

        String expectedOutput = "\n\tСписок вибраних путівок порожній.\n";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);
    }

    @Test
    void testShowVouchersNotEmpty() {
        InputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);

        systemVouchers.showVouchers(true);

        assertTrue(true);
    }

    @Test
    void testGetVouchers() {
        List<Voucher> list = List.of(systemVouchers.getVouchers().get(0),
                systemVouchers.getVouchers().get(1),
                systemVouchers.getVouchers().get(2));
        assertNotNull(list);

        assertEquals(list, systemVouchers.getVouchers().getList());
    }

    @Test
    void testSetVouchersType() {
        systemVouchers.setVouchersByType(VoucherType.Excursion);
        ListVouchers filteredVouchers = systemVouchers.getVouchers();

        assertEquals(1, filteredVouchers.size());
        assertTrue(filteredVouchers.getList().contains(voucher1));
    }

    @Test
    void testSetVouchersCountry() {
        systemVouchers.setVouchersByCountry(Country.Italy);
        ListVouchers filteredVouchers = systemVouchers.getVouchers();

        assertEquals(2, filteredVouchers.size());
        assertTrue(filteredVouchers.getList().contains(voucher1));
        assertTrue(filteredVouchers.getList().contains(voucher3));
    }

    @Test
    void testSetVouchersTransport() {
        systemVouchers.setVouchersByTransport(VoucherTransport.Plane);
        ListVouchers filteredVouchers = systemVouchers.getVouchers();

        assertEquals(2, filteredVouchers.size());
        assertTrue(filteredVouchers.getList().contains(voucher2));
        assertTrue(filteredVouchers.getList().contains(voucher3));
    }

    @Test
    void testSetVouchersNutrition() {
        systemVouchers.setVouchersByNutrition(Nutrition.AllInclusive);
        ListVouchers filteredVouchers = systemVouchers.getVouchers();

        assertEquals(2, filteredVouchers.size());
        assertTrue(filteredVouchers.getList().contains(voucher1));
        assertTrue(filteredVouchers.getList().contains(voucher2));
    }

    @Test
    void testSetVouchersByBudget() {
        systemVouchers.setVouchersByBudget(Budget.Medium);
        ListVouchers filteredVouchers = systemVouchers.getVouchers();

        assertEquals(2, filteredVouchers.size());
        assertTrue(filteredVouchers.getList().contains(voucher2));
        assertTrue(filteredVouchers.getList().contains(voucher3));
    }

    @Test
    public void testSortByPriceAscending() {
        systemVouchers.sortVouchersByPrice(true);
        ListVouchers sortedList = systemVouchers.getVouchers();

        assertEquals(1200, sortedList.get(0).getPrice());
        assertEquals(2600, sortedList.get(1).getPrice());
        assertEquals(3000, sortedList.get(2).getPrice());
    }

    @Test
    public void testSortByPriceDescending() {
        systemVouchers.sortVouchersByPrice(false);
        ListVouchers sortedList = systemVouchers.getVouchers();

        assertEquals(3000, sortedList.get(0).getPrice());
        assertEquals(2600, sortedList.get(1).getPrice());
        assertEquals(1200, sortedList.get(2).getPrice());
    }

    @Test
    public void testSortByDaysAscending() {
        systemVouchers.sortVouchersByDays(true);
        ListVouchers sortedList = systemVouchers.getVouchers();

        assertEquals(5, sortedList.get(0).getNumberOfDays());
        assertEquals(10, sortedList.get(1).getNumberOfDays());
        assertEquals(13, sortedList.get(2).getNumberOfDays());
    }

    @Test
    public void testSortByDaysDescending() {
        systemVouchers.sortVouchersByDays(false);
        ListVouchers sortedList = systemVouchers.getVouchers();

        assertEquals(13, sortedList.get(0).getNumberOfDays());
        assertEquals(10, sortedList.get(1).getNumberOfDays());
        assertEquals(5, sortedList.get(2).getNumberOfDays());
    }

    @Test
    public void testSortByDateAscending() {
        systemVouchers.sortVouchersByDate(true);
        ListVouchers sortedList = systemVouchers.getVouchers();

        assertEquals(LocalDate.of(2024, 10, 25), sortedList.get(0).getVoucherDate());
        assertEquals(LocalDate.of(2024, 11, 15), sortedList.get(1).getVoucherDate());
        assertEquals(LocalDate.of(2024, 12, 11), sortedList.get(2).getVoucherDate());
    }

    @Test
    public void testSortByDateDescending() {
        systemVouchers.sortVouchersByDate(false);
        ListVouchers sortedList = systemVouchers.getVouchers();

        assertEquals(LocalDate.of(2024, 12, 11), sortedList.get(0).getVoucherDate());
        assertEquals(LocalDate.of(2024, 11, 15), sortedList.get(1).getVoucherDate());
        assertEquals(LocalDate.of(2024, 10, 25), sortedList.get(2).getVoucherDate());
    }

    @Test
    public void testCloseDataFileLogger() {
        systemVouchers = SystemVouchers.getInstance();
        systemVouchers.closeDataFileLogger();

        assertTrue(true);
    }
}