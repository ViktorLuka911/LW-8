package Commands;

import Commands.AddVoucherCommand;
import Loggers.LoggerInfo;
import SelectParameters.SelectParameters;
import SystemVouchers.SystemVouchers;
import Utilities.Utilities;
import Voucher.Voucher;
import VoucherParameters.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AddVoucherCommandTest {

    @Mock
    private SystemVouchers mockSystemVouchers;

    @Mock
    private LoggerInfo mockLoggerInfo;

    @InjectMocks
    private AddVoucherCommand command;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() {
        // Мокаємо Voucher
        when(SelectParameters.selectVoucherType()).thenReturn(VoucherType.Shopping);
        when(SelectParameters.selectCountry()).thenReturn(Country.Germany);
        when(SelectParameters.selectTransport()).thenReturn(VoucherTransport.Train);
        when(SelectParameters.selectNutrition()).thenReturn(Nutrition.AllInclusive);
        when(SelectParameters.selectBudget()).thenReturn(Budget.Medium);
        when(Utilities.getValidatedInput(1, 5)).thenReturn(4);
        when(Utilities.getValidatedDateInput()).thenReturn("2024-11-20");

        command.execute();

        // Перевірка, що метод addVoucher був викликаний
        verify(mockSystemVouchers, times(1)).addVoucher(any(Voucher.class));

        // Перевірка, що метод logInfo був викликаний
        verify(mockLoggerInfo, times(1)).logInfo(contains("Путівку додано"));
    }
}
