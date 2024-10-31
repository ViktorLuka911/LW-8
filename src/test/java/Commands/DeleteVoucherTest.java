package Commands;

import Loggers.LoggerInfo;
import SystemVouchers.SystemVouchers;
import Voucher.Voucher;
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

        deleteVoucherCommand = new DeleteVoucherCommand("Видалити путівку");
        deleteVoucherCommand.setVouchers(mockSystemVouchers);
        deleteVoucherCommand.setLoggerInfo(mockLoggerInfo);
    }

    @Test
    void testExecuteWhenNoVouchers() {
        InputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);
        when(mockScanner.nextLine()).thenReturn("\n");

        when(mockSystemVouchers.getVouchers()).thenReturn(new ListVouchers());

        deleteVoucherCommand.execute();

        verify(mockSystemVouchers, never()).showVouchers(false);
        verify(mockLoggerInfo, never()).logInfo(anyString());
    }

    @Test
    void testExecuteWithVouchers() {
        InputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);
        ListVouchers vouchers = new ListVouchers();
        Voucher mockVoucher = Mockito.mock(Voucher.class);
        when(mockVoucher.toStringLogger()).thenReturn("Mock Voucher");
        vouchers.add(mockVoucher);

        when(mockSystemVouchers.getVouchers()).thenReturn(vouchers);

        deleteVoucherCommand.execute();

        verify(mockSystemVouchers).showVouchers(false);
        verify(mockSystemVouchers).deleteVoucher(mockVoucher);
    }
}
