package Commands;

import Loggers.LoggerInfo;
import SystemVouchers.SystemVouchers;
import VoucherParameters.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import SelectParameters.SelectParameters;

import static org.mockito.Mockito.*;

class ShowListTest {

    private ShowListCommand showListCommand;
    private SystemVouchers mockSystemVouchers;
    private LoggerInfo mockLoggerInfo;

    @BeforeEach
    void setUp() {
        mockSystemVouchers = Mockito.mock(SystemVouchers.class);
        mockLoggerInfo = Mockito.mock(LoggerInfo.class);
    }

    @Test
    void testExecuteShowAllVouchers() {
        showListCommand = new ShowListCommand("Вивести всі путівки");
        showListCommand.setVouchers(mockSystemVouchers);
        showListCommand.setLoggerInfo(mockLoggerInfo);

        showListCommand.execute();

        verify(mockSystemVouchers).resetVouchers();
        verify(mockLoggerInfo).logInfo("Користувач вибрав перегляд всього списку.");
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteFilterByType() {
        showListCommand = new ShowListCommand("За типом");
        showListCommand.setVouchers(mockSystemVouchers);
        showListCommand.setLoggerInfo(mockLoggerInfo);

        try (MockedStatic<SelectParameters> mockedStatic = Mockito.mockStatic(SelectParameters.class)) {
            VoucherType mockType = Mockito.mock(VoucherType.class);
            mockedStatic.when(SelectParameters::selectVoucherType).thenReturn(mockType);

            showListCommand.execute();

            verify(mockSystemVouchers).setVouchersByType(mockType);
            verify(mockLoggerInfo).logInfo("Користувач вибрав фільтрацію списку за типом путівки.");
            verify(mockSystemVouchers).showVouchers(true);
        }
    }

    @Test
    void testExecuteFilterByCountry() {
        showListCommand = new ShowListCommand("За країною");
        showListCommand.setVouchers(mockSystemVouchers);
        showListCommand.setLoggerInfo(mockLoggerInfo);

        try (MockedStatic<SelectParameters> mockedStatic = Mockito.mockStatic(SelectParameters.class)) {
            Country mockCountry = Mockito.mock(Country.class);
            mockedStatic.when(SelectParameters::selectCountry).thenReturn(mockCountry);

            showListCommand.execute();

            verify(mockSystemVouchers).setVouchersByCountry(mockCountry);
            verify(mockLoggerInfo).logInfo("Користувач вибрав фільтрацію списку за країною.");
            verify(mockSystemVouchers).showVouchers(true);
        }
    }

    @Test
    void testExecuteFilterByTransport() {
        showListCommand = new ShowListCommand("За транспортом");
        showListCommand.setVouchers(mockSystemVouchers);
        showListCommand.setLoggerInfo(mockLoggerInfo);

        try (MockedStatic<SelectParameters> mockedStatic = Mockito.mockStatic(SelectParameters.class)) {
            VoucherTransport mockTransport = Mockito.mock(VoucherTransport.class);
            mockedStatic.when(SelectParameters::selectTransport).thenReturn(mockTransport);

            showListCommand.execute();

            verify(mockSystemVouchers).setVouchersByTransport(mockTransport);
            verify(mockLoggerInfo).logInfo("Користувач вибрав фільтрацію списку за типом транспорту.");
            verify(mockSystemVouchers).showVouchers(true);
        }
    }

    @Test
    void testExecuteFilterByBudget() {
        showListCommand = new ShowListCommand("За бюджетом");
        showListCommand.setVouchers(mockSystemVouchers);
        showListCommand.setLoggerInfo(mockLoggerInfo);

        try (MockedStatic<SelectParameters> mockedStatic = Mockito.mockStatic(SelectParameters.class)) {
            Budget mockBudget = Mockito.mock(Budget.class);
            mockedStatic.when(SelectParameters::selectBudget).thenReturn(mockBudget);

            showListCommand.execute();

            verify(mockSystemVouchers).setVouchersByBudget(mockBudget);
            verify(mockLoggerInfo).logInfo("Користувач вибрав фільтрацію списку за типом бюджету.");
            verify(mockSystemVouchers).showVouchers(true);
        }
    }

    @Test
    void testExecuteFilterByNutrition() {
        showListCommand = new ShowListCommand("За харчуванням");
        showListCommand.setVouchers(mockSystemVouchers);
        showListCommand.setLoggerInfo(mockLoggerInfo);

        try (MockedStatic<SelectParameters> mockedStatic = Mockito.mockStatic(SelectParameters.class)) {
            Nutrition mockNutrition = Mockito.mock(Nutrition.class);
            mockedStatic.when(SelectParameters::selectNutrition).thenReturn(mockNutrition);

            showListCommand.execute();

            verify(mockSystemVouchers).setVouchersByNutrition(mockNutrition);
            verify(mockLoggerInfo).logInfo("Користувач вибрав фільтрацію списку за типом харчування.");
            verify(mockSystemVouchers).showVouchers(true);
        }
    }
}