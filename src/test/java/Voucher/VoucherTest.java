package Voucher;

import SelectParameters.SelectParameters;
import Utilities.Utilities;
import VoucherParameters.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

public class VoucherTest {
    private Voucher voucher;
    MockedStatic<Utilities> utilitiesMock;
    MockedStatic<SelectParameters> selectParameters;

    @BeforeEach
    public void setUp() {
        // Ініціалізація об'єкта Voucher перед кожним тестом
        voucher = new Voucher(Country.Italy, 2150,
                VoucherType.Excursion, VoucherTransport.Train,
                Nutrition.AllInclusive, Budget.Medium,
                4, LocalDate.of(2024, 11, 11));
        utilitiesMock = mockStatic(Utilities.class);
        selectParameters = mockStatic(SelectParameters.class);
    }

    @AfterEach
    public void tearDown() {
        if (utilitiesMock != null) {
            utilitiesMock.close();
        }

        if (selectParameters != null) {
            selectParameters.close();
        }
    }

    @Test
    public void testVoucherCreation() {
        // Перевірка коректності створення об'єкта Voucher
        assertNotNull(voucher, "Об'єкт ваучера не повинен бути null");
        Assertions.assertEquals(Country.Italy, voucher.getCountry());
        Assertions.assertEquals(2150, voucher.getPrice());
        Assertions.assertEquals(VoucherType.Excursion, voucher.getType());
        Assertions.assertEquals(VoucherTransport.Train, voucher.getTransport());
        Assertions.assertEquals(Budget.Medium, voucher.getBudget());
        Assertions.assertEquals(Nutrition.AllInclusive, voucher.getNutrition());
        Assertions.assertEquals(4, voucher.getNumberOfDays());
        Assertions.assertEquals(LocalDate.of(2024, 11, 11), voucher.getVoucherDate());
    }

    @Test
    public void testSetCountry() {
        voucher.setCountry(Country.Italy);
        Assertions.assertEquals(Country.Italy, voucher.getCountry());
    }

    @Test
    public void testSetPrice() {
        voucher.setPrice(3000);
        Assertions.assertEquals(3000, voucher.getPrice());
    }

    @Test
    public void testSetType() {
        voucher.setType(VoucherType.Excursion);
        Assertions.assertEquals(VoucherType.Excursion, voucher.getType());
    }

    @Test
    public void testSetTransport() {
        voucher.setTransport(VoucherTransport.Bus);
        Assertions.assertEquals(VoucherTransport.Bus, voucher.getTransport());
    }

    @Test
    public void testSetBudget() {
        voucher.setBudget(Budget.High);
        Assertions.assertEquals(Budget.High, voucher.getBudget());
    }

    @Test
    public void testSetNutrition() {
        voucher.setNutrition(Nutrition.AllInclusive);
        Assertions.assertEquals(Nutrition.AllInclusive, voucher.getNutrition());
    }

    @Test
    public void testSetVoucherDate() {
        LocalDate newDate = LocalDate.of(2024, 12, 15);
        voucher.setTripDate(newDate);
        Assertions.assertEquals(newDate, voucher.getVoucherDate());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("Екскурсія                Італія              Потяг               Все включено        Середній       4       2024-11-11     2150           ", voucher.toString());
    }

    @Test
    public void testEquals() {
        Voucher voucher1 = voucher;

        assertTrue(voucher.equals(voucher1));
    }

    @Test
    public void testSameEquals() {
        Voucher voucher1 = new Voucher(voucher.getCountry(), voucher.getPrice(),
                voucher.getType(), voucher.getTransport(), voucher.getNutrition(), voucher.getBudget(),
                voucher.getNumberOfDays(), voucher.getVoucherDate());

        assertTrue(voucher.equals(voucher1));
    }

    @Test
    public void testNotEquals() {
        String object = "123";

        assertFalse(voucher.equals(object));
    }

    @Test
    public void testHashCode() {
        Assertions.assertEquals(voucher.hashCode(), voucher.hashCode());
    }

    @Test
    public void toStringLogger() {
        Assertions.assertEquals(String.format("Тип: %s%nКраїна: %s%nТранспорт: %s%nХарчування: %s%nБюджет: %s%nКількість днів: %d%nДата поїздки: %s%nЦіна: %d",
                "Екскурсія",
                "Італія",
                "Потяг",
                "Все включено",
                "Середній",
                4,
                "2024-11-11",
                2150), voucher.toStringLogger());

    }

    @Test
    public void testFromString() {
        String line = "Екскурсія                Італія              Потяг               Все включено        Середній       4       2024-11-11     2150           \n";

        Voucher voucher = Voucher.fromString(line);

        assertNotNull(voucher);
        Assertions.assertEquals(Country.Italy, voucher.getCountry());
        Assertions.assertEquals(2150, voucher.getPrice());
        Assertions.assertEquals(VoucherType.Excursion, voucher.getType());
        Assertions.assertEquals(VoucherTransport.Train, voucher.getTransport());
        Assertions.assertEquals(Budget.Medium, voucher.getBudget());
        Assertions.assertEquals(Nutrition.AllInclusive, voucher.getNutrition());
        Assertions.assertEquals(4, voucher.getNumberOfDays());
        Assertions.assertEquals(LocalDate.of(2024, 11, 11), voucher.getVoucherDate());
    }

    @Test
    void testDefaultConstructor() {

        when(SelectParameters.selectVoucherType()).thenReturn(VoucherType.Shopping);
        when(SelectParameters.selectCountry()).thenReturn(Country.Germany);
        when(SelectParameters.selectTransport()).thenReturn(VoucherTransport.Train);
        when(SelectParameters.selectNutrition()).thenReturn(Nutrition.AllInclusive);
        when(SelectParameters.selectBudget()).thenReturn(Budget.Medium);
        when(Utilities.getValidatedInput(1, 5)).thenReturn(4);
        when(Utilities.getValidatedDateInput()).thenReturn("2024-11-20");

        Voucher voucher1 = new Voucher();

        assertEquals(VoucherType.Shopping, voucher1.getType());
        assertEquals(Country.Germany, voucher1.getCountry());
        assertEquals(VoucherTransport.Train, voucher1.getTransport());
        assertEquals(Nutrition.AllInclusive, voucher1.getNutrition());
        assertEquals(Budget.Medium, voucher1.getBudget());
        assertEquals(4, voucher1.getNumberOfDays());
        assertEquals("2024-11-20", voucher1.getVoucherDate().toString());

        verifyStatic(SelectParameters.class);
        SelectParameters.selectVoucherType();
        verifyStatic(SelectParameters.class);
        SelectParameters.selectCountry();
        verifyStatic(SelectParameters.class);
        SelectParameters.selectTransport();
        verifyStatic(SelectParameters.class);
        SelectParameters.selectNutrition();
        verifyStatic(SelectParameters.class);
        SelectParameters.selectBudget();

        verifyStatic(Utilities.class);
        Utilities.getValidatedInput(1, 5);
        verifyStatic(Utilities.class);
        Utilities.getValidatedDateInput();
    }

    @Test
    public void testSelectBudget() {
        Voucher voucher = new Voucher(null, 200, null, null, null, null, 0, null);
        Budget budget = Budget.Medium;
        selectParameters.when(SelectParameters::selectBudget).thenReturn(budget);

        voucher.selectBudget();
        Assertions.assertEquals(Budget.Medium, voucher.getBudget());
    }

    @Test
    public void testSelectCountry() {
        Voucher voucher = new Voucher(null, 200, null, null, null, null, 0, null);
        Country country = Country.USA;

        selectParameters.when(SelectParameters::selectCountry).thenReturn(country);

        voucher.selectCountry();
        Assertions.assertEquals(Country.USA, voucher.getCountry());

    }

    @Test
    public void testSelectDate() {
        Voucher voucher = new Voucher(null, 200, null, null, null, null, 0, null);
        String inputDate = "2024-11-20";

        utilitiesMock.when(Utilities::getValidatedDateInput).thenReturn(inputDate);

        voucher.selectDate();

        Assertions.assertEquals("2024-11-20", voucher.getVoucherDate().toString());
    }

    @Test
    void testSetNumberOfDays() {
        Voucher voucher = new Voucher(null, 0, null, null, null, null, 0, null);

        voucher.setType(VoucherType.Recreation);
        when(Utilities.getValidatedInput(1, 14)).thenReturn(5);

        voucher.selectNumberOfDays();

        int totalPrice = 5 * VoucherType.Recreation.getPrice();

        Assertions.assertEquals(5, voucher.getNumberOfDays());
        Assertions.assertEquals(totalPrice, voucher.getPrice());
    }

    @Test
    void testExecuteOther() {
        Nutrition nutrition = Nutrition.NoMeals;
        VoucherType type = VoucherType.Excursion;

        voucher.setType(type);
        voucher.setPrice(type.getPrice());
        Mockito.when(SelectParameters.selectNutrition()).thenReturn(nutrition);

        voucher.selectNutrition();

        int price = nutrition.getPrice() + type.getPrice();

        Assertions.assertEquals(price, voucher.getPrice());
        Assertions.assertEquals(nutrition, voucher.getNutrition());
    }

    @Test
    void testExecuteTreatment() {
        Nutrition nutrition = Nutrition.AllInclusive;
        VoucherType type = VoucherType.Recreation;

        voucher.setType(type);
        voucher.setPrice(type.getPrice());
        Mockito.when(SelectParameters.selectNutrition()).thenReturn(nutrition);

        voucher.selectNutrition();

        int price = nutrition.getPrice() + type.getPrice();

        Assertions.assertEquals(nutrition, voucher.getNutrition());
        Assertions.assertEquals(price, voucher.getPrice());
    }

    @Test
    void testExecuteCruise() {
        Nutrition nutrition = Nutrition.AllInclusive;
        VoucherType type = VoucherType.Cruise;

        voucher.setType(type);
        voucher.setPrice(type.getPrice());

        voucher.selectNutrition();
        Mockito.when(SelectParameters.selectNutrition()).thenReturn(nutrition);

        int price = nutrition.getPrice() + type.getPrice();

        Assertions.assertEquals(nutrition, voucher.getNutrition());
        Assertions.assertEquals(price, voucher.getPrice());
    }

    @Test
    public void testSelectTransport() {
        Voucher voucher = new Voucher(null, 200, null, null, null, null, 0, null);
        VoucherTransport transport = VoucherTransport.Plane;

        when(SelectParameters.selectTransport()).thenReturn(transport);

        voucher.selectTransport();

        int price = transport.getPrice();


        Assertions.assertEquals(200 + price, voucher.getPrice());
        Assertions.assertEquals(transport, voucher.getTransport());
    }

    @Test
    public void testSelectType() {
        Voucher voucher = new Voucher(null, 200, null, null, null, null, 0, null);
        VoucherType type = VoucherType.EduTour;

        when(SelectParameters.selectVoucherType()).thenReturn(type);

        voucher.selectType();

        int price = type.getPrice();

        Assertions.assertEquals(200 + price, voucher.getPrice());
        Assertions.assertEquals(type, voucher.getType());
    }
}