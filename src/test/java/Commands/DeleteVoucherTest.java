package Commands;

import Loggers.LoggerInfo;
import SystemVouchers.SystemVouchers;
import Voucher.Voucher;
import Utilities.Utilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import List.ListVouchers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

class DeleteVoucherTest {

    private DeleteVoucherCommand deleteVoucherCommand;
    private SystemVouchers mockSystemVouchers;
    private LoggerInfo mockLoggerInfo;
    private Scanner mockScanner;

    @BeforeEach
    void setUp() {
        mockSystemVouchers = Mockito.mock(SystemVouchers.class);
        mockLoggerInfo = Mockito.mock(LoggerInfo.class);
        mockScanner = Mockito.mock(Scanner.class);

        // Ініціалізація команди
        deleteVoucherCommand = new DeleteVoucherCommand("Видалити путівку");
        deleteVoucherCommand.setVouchers(mockSystemVouchers);
        deleteVoucherCommand.setLoggerInfo(mockLoggerInfo);
    }

    @Test
    void testExecuteWhenNoVouchers() {
        InputStream in = new ByteArrayInputStream("\n".getBytes()); // Симуляція натискання Enter
        System.setIn(in); // Заміна стандартного вводу
        when(mockScanner.nextLine()).thenReturn("\n");

        when(mockSystemVouchers.getVouchers()).thenReturn(new ListVouchers());

        // Виклик методу execute
        deleteVoucherCommand.execute();

        // Перевірка, що showVouchers() не був викликаний
        verify(mockSystemVouchers, never()).showVouchers(false);

        // Перевірка, що метод loggerInfo не викликаний
        verify(mockLoggerInfo, never()).logInfo(anyString());
    }

    @Test
    void testExecuteWithVouchers() {
        InputStream in = new ByteArrayInputStream("1\n".getBytes()); // Симуляція натискання Enter
        System.setIn(in); // Заміна стандартного вводу
        // Налаштування мок-об'єкта для списку ваучерів
        ListVouchers vouchers = new ListVouchers();
        Voucher mockVoucher = Mockito.mock(Voucher.class);
        when(mockVoucher.toStringLogger()).thenReturn("Mock Voucher");
        vouchers.add(mockVoucher);

        when(mockSystemVouchers.getVouchers()).thenReturn(vouchers);

        // Виклик методу execute
        deleteVoucherCommand.execute();

        // Перевірка, чи був викликаний showVouchers()
        verify(mockSystemVouchers).showVouchers(false);

        // Перевірка, що ваучер був видалений
        verify(mockSystemVouchers).deleteVoucher(mockVoucher);

        // Перевірка, що метод logInfo був викликаний
        verify(mockLoggerInfo).logInfo("\tПутівку видалено.\nMock Voucher");
    }
}
