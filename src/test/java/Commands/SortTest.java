package Commands;

import Loggers.LoggerInfo;
import SystemVouchers.SystemVouchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class SortTest {

    private SortCommand sortCommand;
    private SystemVouchers mockSystemVouchers;
    private LoggerInfo mockLoggerInfo;

    @BeforeEach
    void setUp() {
        mockSystemVouchers = Mockito.mock(SystemVouchers.class);
        mockLoggerInfo = Mockito.mock(LoggerInfo.class);
    }

    @Test
    void testExecuteSortByDaysAscending() {
        sortCommand = new SortCommand("Сортувати за кількістю днів", "За зростанням");
        sortCommand.setVouchers(mockSystemVouchers);
        sortCommand.setLoggerInfo(mockLoggerInfo);

        sortCommand.execute();

        verify(mockSystemVouchers).sortVouchersByDays(true);
        verify(mockLoggerInfo).logInfo("Користувач вибрав сортування за кількістю днів у порядку зростання.");
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteSortByDaysDescending() {
        sortCommand = new SortCommand("Сортувати за кількістю днів", "За спаданням");
        sortCommand.setVouchers(mockSystemVouchers);
        sortCommand.setLoggerInfo(mockLoggerInfo);

        sortCommand.execute();

        verify(mockSystemVouchers).sortVouchersByDays(false);
        verify(mockLoggerInfo).logInfo("Користувач вибрав сортування за кількістю днів у порядку спадання.");
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteSortByPriceAscending() {
        sortCommand = new SortCommand("Сортувати за ціною", "За зростанням");
        sortCommand.setVouchers(mockSystemVouchers);
        sortCommand.setLoggerInfo(mockLoggerInfo);

        sortCommand.execute();

        verify(mockSystemVouchers).sortVouchersByPrice(true);
        verify(mockLoggerInfo).logInfo("Користувач вибрав сортування за ціною путівки у порядку зростання.");
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteSortByPriceDescending() {
        sortCommand = new SortCommand("Сортувати за ціною", "За спаданням");
        sortCommand.setVouchers(mockSystemVouchers);
        sortCommand.setLoggerInfo(mockLoggerInfo);

        sortCommand.execute();

        verify(mockSystemVouchers).sortVouchersByPrice(false);
        verify(mockLoggerInfo).logInfo("Користувач вибрав сортування за ціною путівки у порядку спадання.");
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteSortByDateAscending() {
        sortCommand = new SortCommand("Сортувати за датою", "За зростанням");
        sortCommand.setVouchers(mockSystemVouchers);
        sortCommand.setLoggerInfo(mockLoggerInfo);

        sortCommand.execute();

        verify(mockSystemVouchers).sortVouchersByDate(true);
        verify(mockLoggerInfo).logInfo("Користувач вибрав сортування за датою путівки у порядку зростання.");
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteSortByDateDescending() {
        sortCommand = new SortCommand("Сортувати за датою", "За спаданням");
        sortCommand.setVouchers(mockSystemVouchers);
        sortCommand.setLoggerInfo(mockLoggerInfo);

        sortCommand.execute();

        verify(mockSystemVouchers).sortVouchersByDate(false);
        verify(mockLoggerInfo).logInfo("Користувач вибрав сортування за датою путівки у порядку спадання.");
        verify(mockSystemVouchers).showVouchers(true);
    }
}
