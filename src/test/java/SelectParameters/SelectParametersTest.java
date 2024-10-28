package SelectParameters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import Utilities.Utilities;
import VoucherParameters.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class SelectParametersTest {

    MockedStatic<Utilities> utilitiesMock;

    @BeforeEach
    void setUp() {
        utilitiesMock = mockStatic(Utilities.class);
    }

    @AfterEach
    void tearDown() {
        utilitiesMock.close();
    }

    @Test
    void testSelectCountry() {
        utilitiesMock.when(() -> Utilities.getValidatedInput(1, Country.values().length))
                .thenReturn(1);

        Country selectedCountry = SelectParameters.selectCountry();
        assertEquals(Country.values()[0], selectedCountry);
    }

    @Test
    void testSelectVoucherType() {
        utilitiesMock.when(() -> Utilities.getValidatedInput(1, VoucherType.values().length))
                .thenReturn(2);

        VoucherType selectedType = SelectParameters.selectVoucherType();
        assertEquals(VoucherType.values()[1], selectedType);
    }

    @Test
    void testSelectTransport() {
        utilitiesMock.when(() -> Utilities.getValidatedInput(1, VoucherTransport.values().length))
                .thenReturn(3);

        VoucherTransport selectedTransport = SelectParameters.selectTransport();
        assertEquals(VoucherTransport.values()[2], selectedTransport);
    }

    @Test
    void testSelectNutrition() {
        utilitiesMock.when(() -> Utilities.getValidatedInput(1, Nutrition.values().length))
                .thenReturn(1);

        Nutrition selectedNutrition = SelectParameters.selectNutrition();
        assertEquals(Nutrition.values()[0], selectedNutrition);
    }

    @Test
    void testSelectBudget() {
        utilitiesMock.when(() -> Utilities.getValidatedInput(1, Budget.values().length))
                .thenReturn(2);

        Budget selectedBudget = SelectParameters.selectBudget();
        assertEquals(Budget.values()[1], selectedBudget);
    }
}
