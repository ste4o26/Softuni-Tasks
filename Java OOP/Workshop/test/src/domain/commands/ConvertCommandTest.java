package domain.commands;

import domain.commands.inputs.ConvertCommandInput;
import domain.entities.Money;
import domain.io.Logger;
import domain.services.ConvertService;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ConvertCommandTest {

    @Test
    public void should_Convert_Money_From_GBP_To_BGN_Using_StubbedExchangeRate() {
        //Given
        //BigDecimal expectedMoneyValue = money.getValue().multiply(STUBBED_EXCHANGE_RATE);
        Money tenGBP = new Money(BigDecimal.TEN, "GBP");
        Money twentyBGN = new Money(BigDecimal.valueOf(20), "BGN");

        ConvertService mockConvertService = mock(ConvertService.class);
        when(mockConvertService.convert(isA(Money.class), anyString())).thenReturn(twentyBGN);

        Logger mockLogger = mock(Logger.class);
        ConvertCommand convertCommand = new ConvertCommand(mockConvertService, mockLogger);

        ConvertCommandInput input = new ConvertCommandInput(tenGBP, "BGN");

        //When
        convertCommand.execute(input);

        //Then
        verify(mockConvertService, times(1)).convert(tenGBP, "BGN");
    }
}