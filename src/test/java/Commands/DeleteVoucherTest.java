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

    private DeleteVoucherCommand command;
    private SystemVouchers mockSystemVouchers;
    private LoggerInfo mocklogger;
    private Scanner mockScanner;

    @BeforeEach
    void setUp() {
        mockSystemVouchers = Mockito.mock(SystemVouchers.class);
        mocklogger = Mockito.mock(LoggerInfo.class);
        mockScanner = Mockito.mock(Scanner.class);

        command = new DeleteVoucherCommand("Видалити путівку");
        command.setVouchers(mockSystemVouchers);
        command.setLoggerInfo(mocklogger);
    }

    @Test
    void testExecuteWhenNoVouchers() {
        InputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);
        when(mockScanner.nextLine()).thenReturn("\n");

        when(mockSystemVouchers.getVouchers()).thenReturn(new ListVouchers());

        command.execute();

        verify(mockSystemVouchers, never()).showVouchers(false);
        verify(mocklogger, never()).logInfo(anyString());
    }

    @Test
    void testExecuteWithVouchers() {
        InputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        ListVouchers vouchers = new ListVouchers();
        Voucher mockVoucher = Mockito.mock(Voucher.class);
        vouchers.add(mockVoucher);

        when(mockSystemVouchers.getVouchers()).thenReturn(vouchers);

        command.execute();

        verify(mockSystemVouchers).showVouchers(false);
        verify(mockSystemVouchers).deleteVoucher(mockVoucher);
    }
}