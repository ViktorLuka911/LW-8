package List;

import Voucher.Voucher;
import VoucherParameters.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListVouchersTest {
    private ListVouchers list;
    private Voucher voucher1;
    private Voucher voucher2;
    private Voucher voucher3;

    @BeforeEach
    public void setUp() {
        list = new ListVouchers();

        voucher1 = new Voucher(Country.ITALY, 2600,
                VoucherType.EXCURSION, VoucherTransport.TRAIN,
                Nutrition.ALL_INCLUSIVE, Budget.LOW,
                10, LocalDate.of(2024, 11, 15));

        voucher2 = new Voucher(Country.GERMANY, 1200,
                VoucherType.RECREATION, VoucherTransport.PLANE,
                Nutrition.ALL_INCLUSIVE, Budget.MEDIUM,
                13, LocalDate.of(2024, 12, 11));

        voucher3 = new Voucher(Country.ITALY, 3000,
                VoucherType.SHOPPING, VoucherTransport.PLANE,
                Nutrition.NONE, Budget.MEDIUM,
                5, LocalDate.of(2024, 10, 25));

        list.add(voucher1);
        list.add(voucher2);
        list.add(voucher3);
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());

        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testGet() {
        assertEquals(voucher1, list.get(0));
    }

    @Test
    public void testSize() {
        assertEquals(3, list.size());
    }

    @Test
    public void testAdd() {
        Voucher voucher = new Voucher(Country.ITALY, 2150,
                VoucherType.EXCURSION, VoucherTransport.TRAIN,
                Nutrition.ALL_INCLUSIVE, Budget.MEDIUM,
                4, LocalDate.of(2024, 11, 11));
        list.add(voucher);

        assertEquals(4, list.size());
        assertEquals(voucher, list.get(3));
    }

    @Test
    public void testGetList() {
        List<Voucher> vouchers = List.of(list.get(0), list.get(1), list.get(2));

        assertEquals(vouchers, list.getList());
    }

    @Test
    public void testClear() {
        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetByType() {
        ListVouchers filteredVouchers = list.getByType(VoucherType.EXCURSION);

        assertEquals(1, filteredVouchers.size());
        assertTrue(filteredVouchers.getList().contains(voucher1));
    }

    @Test
    public void testGetByCountry() {
        ListVouchers filteredVouchers = list.getByCountry(Country.ITALY);

        assertEquals(2, filteredVouchers.size());
        assertTrue(filteredVouchers.getList().contains(voucher1));
        assertTrue(filteredVouchers.getList().contains(voucher3));
    }

    @Test
    public void testGetByTransport() {
        ListVouchers filteredVouchers = list.getByTransport(VoucherTransport.PLANE);

        assertEquals(2, filteredVouchers.size());
        assertTrue(filteredVouchers.getList().contains(voucher2));
        assertTrue(filteredVouchers.getList().contains(voucher3));
    }

    @Test
    public void testGetByNutrition() {
        ListVouchers filteredVouchers = list.getByNutrition(Nutrition.ALL_INCLUSIVE);

        assertEquals(2, filteredVouchers.size());
        assertTrue(filteredVouchers.getList().contains(voucher1));
        assertTrue(filteredVouchers.getList().contains(voucher2));
    }

    @Test
    public void testGetByBudget() {
        ListVouchers filteredVouchers = list.getByBudget(Budget.MEDIUM);

        assertEquals(2, filteredVouchers.size());
        assertTrue(filteredVouchers.getList().contains(voucher2));
        assertTrue(filteredVouchers.getList().contains(voucher3));
    }

    @Test
    public void testSortByPriceAscending() {
        list.sortByPrice(true);

        assertEquals(1200, list.get(0).getPrice());
        assertEquals(2600, list.get(1).getPrice());
        assertEquals(3000, list.get(2).getPrice());
    }

    @Test
    public void testSortByPriceDescending() {
        list.sortByPrice(false);

        assertEquals(3000, list.get(0).getPrice());
        assertEquals(2600, list.get(1).getPrice());
        assertEquals(1200, list.get(2).getPrice());
    }

    @Test
    public void testSortByDaysAscending() {
        list.sortByDays(true);

        assertEquals(5, list.get(0).getNumberOfDays());
        assertEquals(10, list.get(1).getNumberOfDays());
        assertEquals(13, list.get(2).getNumberOfDays());
    }

    @Test
    public void testSortByDaysDescending() {
        list.sortByDays(false);

        assertEquals(13, list.get(0).getNumberOfDays());
        assertEquals(10, list.get(1).getNumberOfDays());
        assertEquals(5, list.get(2).getNumberOfDays());
    }

    @Test
    public void testSortByDateAscending() {
        list.sortByDate(true);

        assertEquals(LocalDate.of(2024, 10, 25), list.get(0).getVoucherDate());
        assertEquals(LocalDate.of(2024, 11, 15), list.get(1).getVoucherDate());
        assertEquals(LocalDate.of(2024, 12, 11), list.get(2).getVoucherDate());
    }

    @Test
    public void testSortByDateDescending() {
        list.sortByDate(false);

        assertEquals(LocalDate.of(2024, 12, 11), list.get(0).getVoucherDate());
        assertEquals(LocalDate.of(2024, 11, 15), list.get(1).getVoucherDate());
        assertEquals(LocalDate.of(2024, 10, 25), list.get(2).getVoucherDate());
    }
}